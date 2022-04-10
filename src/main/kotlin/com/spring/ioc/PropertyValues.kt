package com.spring.ioc

class PropertyValues {
    private val propertyValues = arrayListOf<PropertyValue>()

    fun addPropertyValue(value: PropertyValue) {
        propertyValues.add(value)
    }

    fun getPropertyValues(): ArrayList<PropertyValue> {
        return propertyValues
    }
}