package com.spring.ioc.factory

interface BeanFactory {
    fun getBean(name: String): Any
}
