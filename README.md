This is a bare-bones demo of reading resources, using pure JDK resource loading and corda-jackson for parsing.

* Class [MyService](cordapp/src/main/kotlin/com/template/MyService.kt) implements the logic 
to load the resource [my-resource.json](config/dev/my-resource.json) and parse it to a 
[Data](cordapp/src/main/kotlin/com/template/Data.kt)
* Class [MyFlow](cordapp/src/main/kotlin/com/template/MyFlow.kt) accesses the service for this bit of data.
* The MockNetwork test [ServiceTests](cordapp/src/test/kotlin/com/template/ServiceTests.kt) 
checks that data has been correctly loaded and is accessible via the flow.
* The [NodeDriver](cordapp/src/test/kotlin/com/template/NodeDriver.kt) checks 
that we can access this result across a RPC call.
