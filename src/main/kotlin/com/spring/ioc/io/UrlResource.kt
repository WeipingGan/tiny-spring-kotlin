package com.spring.ioc.io

import java.io.InputStream
import java.net.URL

class UrlResource(var url: URL) : Resource{

    override fun getInputStream(): InputStream {
        val openConnection = url.openConnection()
        openConnection.connect()
        return openConnection.getInputStream()
    }

}