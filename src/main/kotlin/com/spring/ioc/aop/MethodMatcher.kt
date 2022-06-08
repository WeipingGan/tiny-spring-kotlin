package com.spring.ioc.aop

import java.lang.reflect.Method

interface MethodMatcher {
    fun matches(method: Method, targetClass: Class<*>): Boolean
}
