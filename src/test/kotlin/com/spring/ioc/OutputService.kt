package com.spring.ioc

import org.junit.jupiter.api.Assertions

class OutputService() {
    private var helloWorldService: HelloWorldService? = null

    fun output(text: String?): String? {
        Assertions.assertNotNull(helloWorldService)
        return text
    }

    fun setHelloWorldService(helloWorldService: HelloWorldService?) {
        this.helloWorldService = helloWorldService
    }
}
