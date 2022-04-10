package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition

class AutowireCapableBeanFactory : AbstractBeanFactory() {

    override fun initBean(beanDefinition: BeanDefinition): Object? {
        try {
            val bean = createBeanInstance(beanDefinition)
            setPropertyValues(bean, beanDefinition)
            return bean
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun createBeanInstance(beanDefinition: BeanDefinition) =
        beanDefinition.beanClass!!.getDeclaredConstructor().newInstance() as Object

    private fun setPropertyValues(bean: Object, beanDefinition: BeanDefinition) {
        beanDefinition.propertyValues?.getPropertyValues()?.forEach { property ->
            val declaredField = bean.`class`.getDeclaredField(property.name)
            declaredField.isAccessible = true
            declaredField.set(bean, property.value)
        }
    }
}