package com.spring.ioc.factory

import com.spring.ioc.BeanDefinition
import com.spring.ioc.BeanReference

class AutowireCapableBeanFactory : AbstractBeanFactory() {

    override fun initBean(beanDefinition: BeanDefinition): Any? {
        try {
            val bean = createBeanInstance(beanDefinition)
            beanDefinition.bean = bean
            setPropertyValues(bean, beanDefinition)
            return bean
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun createBeanInstance(beanDefinition: BeanDefinition) =
        beanDefinition.beanClass!!.getDeclaredConstructor().newInstance() as Any

    private fun setPropertyValues(bean: Any, beanDefinition: BeanDefinition) {
        beanDefinition.propertyValues.getPropertyValues().forEach { property ->
            val declaredField = bean.javaClass.getDeclaredField(property.name)
            declaredField.isAccessible = true
            var value = property.value
            if (value is BeanReference) {
                val beanReference = value as BeanReference
                value = getBean(beanReference.name)
            }
            declaredField.set(bean, value)
        }
    }
}
