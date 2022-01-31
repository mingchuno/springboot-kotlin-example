package xyz.gutugt.springbootkotlinexample.counter

data class CounterRequest(val key: String)

data class CounterResponse(val count: Long)
