package com.spring.ioc.context

import com.spring.ioc.factory.AbstractBeanFactory
import com.spring.ioc.io.ResourceLoader
import com.spring.ioc.xml.XmlBeanDefinitionReader

class ClassPathXmlApplicationContext(private val configLocation: String, override val beanFactory: AbstractBeanFactory) : AbstractApplicationContext(beanFactory) {
    init {
        refresh()
    }

    override fun refresh() {
        val xmlBeanDefinitionReader = XmlBeanDefinitionReader(ResourceLoader())
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation)
        for (beanDefinitionEntry in xmlBeanDefinitionReader.getRegistry().entries) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.key, beanDefinitionEntry.value)
        }
    }
}
