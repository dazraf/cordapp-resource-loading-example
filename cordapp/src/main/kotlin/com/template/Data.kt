package com.template

import net.corda.client.jackson.JacksonSupport

data class Data(val name: String) {
  companion object {
    private val OBJECT_MAPPER = JacksonSupport.createNonRpcMapper()

    /**
     * simple parser using Jackson
     */
    fun parse(json: String): Data = OBJECT_MAPPER.readValue(json, Data::class.java)
  }
}