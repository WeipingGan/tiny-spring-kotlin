package com.spring.ioc.context

import com.spring.ioc.factory.BeanFactory

abstract class AbstractApplicationContext(open val beanFactory: BeanFactory) : ApplicationContext {
    override fun getBean(name: String): Object {
        return beanFactory.getBean(name)
    }
    abstract fun refresh()
}
