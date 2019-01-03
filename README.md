This is a bare-bones demo of reading resources.

* Class [MyService](cordapp/src/main/kotlin/com/template/MyService.kt) implements the logic 
to load the resource [my-resource.json](config/dev/my-resource.json) and parse it to a 
[Data](/Users/fuzz/tmp/cordapp-template-kotlin/cordapp/src/main/kotlin/com/template/Data.kt)
* Class [MyFlow](cordapp/src/main/kotlin/com/template/MyFlow.kt) accesses the service for this bit of data.
* The MockNetwork test [ServiceTests](/Users/fuzz/tmp/cordapp-template-kotlin/cordapp/src/test/kotlin/com/template/ServiceTests.kt) 
checks that data has been correctly loaded and is accessible via the flow.
* The [NodeDriver](/Users/fuzz/tmp/cordapp-template-kotlin/cordapp/src/test/kotlin/com/template/NodeDriver.kt) checks 
that we can access this result across a RPC call.
 

