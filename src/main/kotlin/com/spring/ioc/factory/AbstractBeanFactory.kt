package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition
import java.util.concurrent.ConcurrentHashMap

abstract class AbstractBeanFactory : BeanFactory {

    private val beanDefinitionMap = ConcurrentHashMap<String, BeanDefinition>()

    override fun getBean(name: String): Object {
        return beanDefinitionMap[name]?.bean!!
    }

    override fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition) {
        val bean = initBean(beanDefinition)
        beanDefinition.bean = bean
        beanDefinitionMap[name] = beanDefinition
    }

    protected abstract fun initBean(beanDefinition: BeanDefinition): Object?
}