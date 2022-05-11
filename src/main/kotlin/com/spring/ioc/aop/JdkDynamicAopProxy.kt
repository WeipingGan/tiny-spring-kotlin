package com.spring.ioc.aop

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class JdkDynamicAopProxy(private val advisedSupport: AdvisedSupport) : AopProxy, InvocationHandler {
    override fun getProxy(): Any {
        return Proxy.newProxyInstance(javaClass.classLoader, arrayOf(advisedSupport.targetSource!!.targetClass), this) as Any
    }

    override fun invoke(proxy: Any?, method: Method?, args: Array<Any>?): Any {
        val methodInterceptor = advisedSupport.methodInterceptor!!
        return methodInterceptor.invoke(ReflectiveMethodInvocation(advisedSupport.targetSource!!.target, method, args))
    }
}
