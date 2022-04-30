package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition
import java.util.concurrent.ConcurrentHashMap

abstract class AbstractBeanFactory : BeanFactory {

    private val beanDefinitionMap = ConcurrentHashMap<String, BeanDefinition>()

    override fun getBean(name: String): Object {
        var bean = beanDefinitionMap[name]?.bean
        if (bean == null) {
            bean = initBean(beanDefinitionMap[name]!!)
        }
        return bean!!
    }

    override fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition) {
        beanDefinitionMap[name] = beanDefinition
    }

    protected abstract fun initBean(beanDefinition: BeanDefinition): Object?
}
