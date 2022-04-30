package com.spring.ioc.io

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ResourceLoaderTest {

    @Test
    fun `test resource loader`() {
        val resourceLoader = ResourceLoader()
        val resource = resourceLoader.getResource("tinyioc.xml")
        val inputStream = resource.getInputStream()
        Assertions.assertNotNull(inputStream)
        inputStream.close()
    }
}
