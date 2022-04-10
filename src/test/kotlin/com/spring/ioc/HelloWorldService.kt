package com.spring.ioc

class HelloWorldService {
    private var text: String = ""

    fun helloWorld(): String {
        return text
    }
}