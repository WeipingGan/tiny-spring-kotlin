package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition

class AutowireCapableBeanFactory : AbstractBeanFactory() {

    override fun initBean(beanDefinition: BeanDefinition): Object? {
        try {
            return beanDefinition.beanClass!!.getDeclaredConstructor().newInstance() as Object
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}