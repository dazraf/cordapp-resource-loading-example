package com.template

import net.corda.core.utilities.getOrThrow
import net.corda.testing.node.MockNetwork
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ServiceTests {
    private val network = MockNetwork(listOf("com.template"))
    private val a = network.createNode()

    init {

    }

    @Before
    fun setup() = network.runNetwork()

    @After
    fun tearDown() = network.stopNodes()

    @Test
    fun `dummy test`() {
        val expectedResult = "Daan"
        val service = a.services.cordaService(MyService::class.java)
        assertEquals(expectedResult, service.data.name)

        val result = a.startFlow(MyFlow()).also { network.runNetwork() }.getOrThrow()
        assertEquals(expectedResult, result)
    }
}