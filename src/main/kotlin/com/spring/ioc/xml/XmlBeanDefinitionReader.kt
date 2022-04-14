package com.spring.ioc.xml

import com.spring.ioc.AbstractBeanDefinitionReader
import com.spring.ioc.BeanDefinition
import com.spring.ioc.PropertyValue
import com.spring.ioc.io.ResourceLoader
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory


class XmlBeanDefinitionReader(resourceLoader: ResourceLoader) : AbstractBeanDefinitionReader(resourceLoader) {

    override fun loadBeanDefinition(location: String) {
        val inputStream = resourceLoader.getResource(location).getInputStream()
        doLoadBeanDefinitions(inputStream)
    }

    private fun doLoadBeanDefinitions(inputStream: InputStream) {
        val factory = DocumentBuilderFactory.newInstance()
        val docBuilder = factory.newDocumentBuilder()
        val doc = docBuilder.parse(inputStream)
        registerBeanDefinition(doc)
        inputStream.close()
    }

    private fun registerBeanDefinition(doc: Document?) {
        val root = doc!!.documentElement
        parseBeanDefinitions(root)
    }

    private fun parseBeanDefinitions(root: Element?) {
        val nl = root!!.childNodes
        for (i in 0 until nl.length) {
            val node = nl.item(i)
            if (node is Element) {
                val ele = node as Element
                processBeanDefinition(ele)
            }
        }
    }

    private fun processBeanDefinition(ele: Element) {
        val name = ele.getAttribute("name")
        val className = ele.getAttribute("class")
        val beanDefinition = BeanDefinition()
        processProperty(ele, beanDefinition)
        beanDefinition.beanClassName = className
        getRegistry()[name] = beanDefinition
    }

    private fun processProperty(ele: Element, beanDefinition: BeanDefinition) {
        val propertyNode = ele.getElementsByTagName("property")
        for (i in 0 until propertyNode.length) {
            val node = propertyNode.item(i)
            if (node is Element) {
                val name = node.getAttribute("name")
                val value = node.getAttribute("value")
                beanDefinition.propertyValues!!.addPropertyValue(PropertyValue(name, value as Object))
            }
        }
    }
}