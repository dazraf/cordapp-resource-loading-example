package com.template

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.StartableByRPC

@StartableByRPC
class MyFlow : FlowLogic<String>() {
  @Suspendable
  override fun call(): String {
    return serviceHub.cordaService(MyService::class.java).data.name
  }
}