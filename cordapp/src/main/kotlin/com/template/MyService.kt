package com.template

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import net.corda.core.node.AppServiceHub
import net.corda.core.node.services.CordaService
import net.corda.core.serialization.SingletonSerializeAsToken
import java.util.*

@CordaService
class MyService(serviceHub: AppServiceHub) : SingletonSerializeAsToken() {
    companion object {
        private const val FILENAME = "my-resource.json"
        private val OBJECT_MAPPER = ObjectMapper().registerModule(KotlinModule())
    }

    val data = loadResource(FILENAME).let { it.toJson() }

    init {
        println(data)
    }

    private fun String.toJson() : Data {
        return OBJECT_MAPPER.readValue(this, Data::class.java)
    }

    private fun loadResource(fileName: String) =
      Scanner(javaClass.classLoader.getResourceAsStream(fileName), "UTF-8").useDelimiter("\\A").next()
}

