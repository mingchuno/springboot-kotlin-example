package xyz.gutugt.springbootkotlinexample.foobar

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import xyz.gutugt.springbootkotlinexample.config.ExampleConfig
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

interface FoobarService {
  fun getFoobar(): Foobar
  fun getConfig(): ExampleConfig
  suspend fun visit(request: CounterRequest): CounterResponse
}

/**
 * Simple Spring Service that simulate a dependency on others, also to see if it handles suspend
 * function well.
 */
@Service
class FoobarServiceImpl(
    private val counterService: CounterService,
    private val exampleConfig: ExampleConfig,
    @Value("\${app.foobar}") private val foobarStr: String
) : FoobarService {
  override fun getFoobar(): Foobar = Foobar(foobarStr)

  override fun getConfig(): ExampleConfig = exampleConfig

  override suspend fun visit(request: CounterRequest): CounterResponse {
    // TODO: validate request params
    return counterService.visit(request).plusOne()
  }
}
