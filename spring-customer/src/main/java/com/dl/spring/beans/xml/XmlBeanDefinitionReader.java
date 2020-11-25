package com.dl.spring.beans.xml;

import com.dl.spring.beans.AbstractBeanDefinitionReader;
import com.dl.spring.beans.BeanDefinition;
import com.dl.spring.BeanReference;
import com.dl.spring.beans.PropertyValue;
import com.dl.spring.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author Jalen.Deng
 * @description xml解析bean定义
 * @date 2020/11/24 14:32
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        //使用io输入流获取xml中所有bean信息
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        //加载解析xml
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * @param inputStream
     * @throws Exception
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        //学过xml相关知识我们可以知道，要获取xml内容首先要构建dom树对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document是个接口，代表整个html或者xml文档，是文档树的根
        Document doc = documentBuilder.parse(inputStream);
        registerBeanDefinitions(doc);
        inputStream.close();

    }

    protected void registerBeanDefinitions(Document doc) {
        //getDocumentElement允许直接访问文档元素的子节点
        Element root = doc.getDocumentElement();
        //解析bean定义核心方法
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) {
        /**
         *<bean name="helloWorldService" class="com.dl.spring.HelloWorldService">
         *      <property name="name" value="Hello World!"></property>
         * </bean>
         */
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        //其实就是解析 <property name="name" value="Hello World!"></property>
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                /**
                 * <bean name="helloWorldService" class="com.dl.spring.HelloWorldService">
                 *         <property name="outputService" ref="outputService"></property>
                 *     </bean>
                 */
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    //ref为helloWorldService,outputService,可以看出，加载顺序从上到下。
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}
