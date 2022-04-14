package com.spring.ioc.io

class ResourceLoader {
    fun getResource(location: String): UrlResource {
        val resource = this.javaClass.classLoader.getResource(location)
        return UrlResource(resource)
    }
}