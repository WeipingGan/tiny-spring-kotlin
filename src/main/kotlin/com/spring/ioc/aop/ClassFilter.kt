package com.spring.ioc.aop

interface ClassFilter {
    fun matches(targetClass: Class<*>): Boolean
}
