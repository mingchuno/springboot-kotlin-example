package xyz.gutugt.springbootkotlinexample.foobar

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse

@RestController
class FoobarController(
    private val foobarService: FoobarService,
) {
  @GetMapping("/foobar")
  fun foobar(): Foobar {
    return foobarService.getFoobar()
  }

  @GetMapping("/visit/{key}")
  suspend fun visit(@PathVariable key: String): CounterResponse {
    return foobarService.visit(CounterRequest(key = key))
  }
}
