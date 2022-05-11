package com.spring.ioc.aop

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation

class TimerInterceptor : MethodInterceptor {
    override fun invoke(invocation: MethodInvocation): Any {
        val time = System.nanoTime()
        println("Invocation of Method " + invocation.method.name + " start!")
        val proceed = invocation.proceed()
        println(
            "Invocation of Method " + invocation.method.name + " end! takes " + (System.nanoTime() - time) +
                " nanoseconds."
        )
        return proceed
    }
}
