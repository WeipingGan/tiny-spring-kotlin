package com.spring.ioc

import com.spring.ioc.factory.AutowireCapableBeanFactory
import com.spring.ioc.io.ResourceLoader
import com.spring.ioc.xml.XmlBeanDefinitionReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BeanFactoryTest {

    @Test
    fun `register a bean in bean factory`() {
        val xmlBeanDefinitionReader = XmlBeanDefinitionReader(ResourceLoader())
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml")

        val autowireCapableBeanFactory = AutowireCapableBeanFactory()
        for(beanDefinitionEntry in xmlBeanDefinitionReader.getRegistry().entries) {
            autowireCapableBeanFactory.registerBeanDefinition(beanDefinitionEntry.key, beanDefinitionEntry.value)
        }

        val bean = autowireCapableBeanFactory.getBean("helloWorldService") as HelloWorldService
        Assertions.assertEquals("Hello World!", bean.helloWorld())
    }
}