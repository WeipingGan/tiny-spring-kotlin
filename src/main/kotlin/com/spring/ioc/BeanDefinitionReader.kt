package com.spring.ioc

interface BeanDefinitionReader {
    fun loadBeanDefinition(location: String)
}
