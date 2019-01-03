package com.template

import net.corda.core.node.AppServiceHub
import net.corda.core.node.services.CordaService
import net.corda.core.serialization.SingletonSerializeAsToken
import java.util.*


@CordaService
class MyService(serviceHub: AppServiceHub) : SingletonSerializeAsToken() {
    companion object {
        private const val FILENAME = "my-resource.json"
    }
    val data = loadResource(FILENAME).let { Data.parse(it) }

    init {
        println(data)
    }

    /**
     * Simple function, using the JDK, to read a resource file
     */
    private fun loadResource(fileName: String) =
      Scanner(javaClass.classLoader.getResourceAsStream(fileName), "UTF-8").useDelimiter("\\A").next()
}

