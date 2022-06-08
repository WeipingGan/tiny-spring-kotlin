package com.spring.ioc.aop

import org.aopalliance.aop.Advice

interface Advisor {
    fun getAdvice(): Advice
}
