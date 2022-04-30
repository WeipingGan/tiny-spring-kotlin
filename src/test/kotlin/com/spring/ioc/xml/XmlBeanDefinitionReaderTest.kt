package com.spring.ioc.xml

import com.spring.ioc.BeanDefinition
import com.spring.ioc.io.ResourceLoader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class XmlBeanDefinitionReaderTest {

    @Test
    @Throws(Exception::class)
    fun test() {
        val xmlBeanDefinitionReader = XmlBeanDefinitionReader(ResourceLoader())
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml")
        val registry: Map<String, BeanDefinition> = xmlBeanDefinitionReader.getRegistry()
        Assertions.assertTrue(registry.isNotEmpty())
    }
}
