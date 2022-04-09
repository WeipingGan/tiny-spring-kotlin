package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition

interface BeanFactory {
    fun getBean(name: String): Object
    fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition)
}