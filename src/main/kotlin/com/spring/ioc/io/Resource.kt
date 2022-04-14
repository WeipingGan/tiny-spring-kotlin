package com.spring.ioc.io

import java.io.InputStream

interface Resource {
    fun getInputStream(): InputStream
}