package com.spring.ioc

class HelloWorldService {
    private var text: String = ""

    private var outputService: OutputService? = null

    fun helloWorld(): String? {
        return outputService?.output(text)
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setOutputService(outputService: OutputService) {
        this.outputService = outputService
    }
}
