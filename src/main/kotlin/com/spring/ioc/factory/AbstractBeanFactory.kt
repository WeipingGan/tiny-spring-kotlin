package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition
import java.util.concurrent.ConcurrentHashMap

abstract class AbstractBeanFactory : BeanFactory {

    private val beanDefinitionMap = ConcurrentHashMap<String, BeanDefinition>()

    private val beanDefinitionNames = arrayListOf<String>()

    override fun getBean(name: String): Object {
        var bean = beanDefinitionMap[name]?.bean
        if (bean == null) {
            bean = initBean(beanDefinitionMap[name]!!)
        }
        return bean!!
    }

    override fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition) {
        beanDefinitionMap[name] = beanDefinition
        beanDefinitionNames.add(name)
    }

    protected abstract fun initBean(beanDefinition: BeanDefinition): Object?
    fun preInstantiateSingletons() {
        val it = beanDefinitionNames.iterator()
        while (it.hasNext()) {
            val beanName = it.next()
            getBean(beanName)
        }
    }
}
