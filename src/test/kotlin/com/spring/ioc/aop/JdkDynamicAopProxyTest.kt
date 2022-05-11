package com.spring.ioc.aop

import com.spring.ioc.HelloWorldService
import com.spring.ioc.context.ClassPathXmlApplicationContext
import com.spring.ioc.factory.AutowireCapableBeanFactory
import org.junit.jupiter.api.Test

class JdkDynamicAopProxyTest {

    @Test
    fun `test timerInterceptor`() {
        val context = ClassPathXmlApplicationContext("tinyioc.xml", AutowireCapableBeanFactory())
        val bean = context.getBean("helloWorldService") as HelloWorldService
        println(bean.helloWorld())

        // helloWorld with aop proxy
        val advisedSupport = AdvisedSupport()
        advisedSupport.targetSource = TargetSource(bean as Object, HelloWorldService::class.java)
        advisedSupport.methodInterceptor = TimerInterceptor()

        val jdkDynamicAopProxy = JdkDynamicAopProxy(advisedSupport)
        val helloWorldServiceImpl = jdkDynamicAopProxy.getProxy() as HelloWorldService

        println(helloWorldServiceImpl.helloWorld())
    }
}
