package xyz.gutugt.springbootkotlinexample.foobar

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import xyz.gutugt.springbootkotlinexample.config.ExampleConfig
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse

private val logger = KotlinLogging.logger {}

/** Simple Rest Controller layer */
@RestController
class FoobarController(
    private val foobarService: FoobarService,
) {
  @GetMapping("/foobar")
  fun foobar(): Foobar {
    logger.debug { "Debug log should work after we configured log level in application.yml" }
    return foobarService.getFoobar()
  }

  @GetMapping("/config")
  fun config(): ExampleConfig {
    return foobarService.getConfig()
  }

  @GetMapping("/visit/{key}")
  suspend fun visit(@PathVariable key: String): CounterResponse {
    return foobarService.visit(CounterRequest(key = key))
  }
}
