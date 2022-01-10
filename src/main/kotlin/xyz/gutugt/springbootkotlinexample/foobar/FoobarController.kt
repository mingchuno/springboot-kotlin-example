package xyz.gutugt.springbootkotlinexample.foobar

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

@RestController
class FoobarController(
    private val foobarService: FoobarService,
    private val counterService: CounterService
) {
  @GetMapping("/foobar")
  fun foobar(): Foobar {
    return foobarService.getFoobar()
  }

  @GetMapping("/visit/{key}")
  fun visit(@PathVariable key: String): CounterResponse {
    // TODO: validate request params
    return counterService.visit(CounterRequest(key = key))
  }
}
