package com.template

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

data class Data(val name: String) {
  companion object {
    /**
     * Jackson mapper using the Kotlin databind module
     */
    private val OBJECT_MAPPER = ObjectMapper().registerModule(KotlinModule())
    /**
     * simple parser using Jackson
     */
    fun parse(json: String) : Data = OBJECT_MAPPER.readValue(json, Data::class.java)
  }
}