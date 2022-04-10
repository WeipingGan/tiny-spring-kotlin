package com.spring.ioc

import com.spring.ioc.factory.AutowireCapableBeanFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BeanFactoryTest {

    @Test
    fun `register a bean in bean factory`() {
        val autowireCapableBeanFactory = AutowireCapableBeanFactory()

        val beanDefinition = BeanDefinition()
        beanDefinition.beanClassName = "com.spring.ioc.HelloWorldService"

        val propertyValues = PropertyValues()
        propertyValues.addPropertyValue(PropertyValue("text", "Hello World!" as Object))
        beanDefinition.propertyValues = propertyValues

        autowireCapableBeanFactory.registerBeanDefinition("helloWorldService", beanDefinition)

        val bean = autowireCapableBeanFactory.getBean("helloWorldService") as HelloWorldService
        Assertions.assertEquals(bean.helloWorld(), "Hello World!")
    }
}