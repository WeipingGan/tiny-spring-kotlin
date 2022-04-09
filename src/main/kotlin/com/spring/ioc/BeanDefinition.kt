package com.spring.ioc

class BeanDefinition() {
    var bean: Object? = null
    var beanClass: Class<*>? = null
    var beanClassName: String? = null
        set(value) {
            field = value
            try {
                beanClass = Class.forName(value)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
}