package com.spring.ioc.context

import com.spring.ioc.HelloWorldService
import com.spring.ioc.factory.AutowireCapableBeanFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationContextTest {

    @Test
    fun `get bean from context`() {
        val context = ClassPathXmlApplicationContext("tinyioc.xml", AutowireCapableBeanFactory())
        val bean = context.getBean("helloWorldService") as HelloWorldService
        Assertions.assertEquals("Hello World!", bean.helloWorld())
    }
}
