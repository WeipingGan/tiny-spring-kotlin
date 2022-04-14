package com.spring.ioc

import com.spring.ioc.io.ResourceLoader

abstract class AbstractBeanDefinitionReader(val resourceLoader: ResourceLoader) : BeanDefinitionReader {
    private val registry = mutableMapOf<String, BeanDefinition>()

    fun getRegistry(): MutableMap<String, BeanDefinition> {
        return registry
    }
}