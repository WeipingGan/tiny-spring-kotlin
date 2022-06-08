package com.spring.ioc.aop

interface PointcutAdvisor : Advisor {
    fun getPointcut(): Pointcut
}
