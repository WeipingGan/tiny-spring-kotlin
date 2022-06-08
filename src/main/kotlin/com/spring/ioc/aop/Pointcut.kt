package com.spring.ioc.aop

interface Pointcut {
    fun getClassFilter(): ClassFilter
    fun getMethodMatcher(): MethodMatcher
}
