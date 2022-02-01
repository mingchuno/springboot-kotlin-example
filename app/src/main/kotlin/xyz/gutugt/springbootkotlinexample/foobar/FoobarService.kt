package xyz.gutugt.springbootkotlinexample.foobar

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

interface FoobarService {
  fun getFoobar(): Foobar
  suspend fun visit(request: CounterRequest): CounterResponse
}

/**
 * Simple Spring Service that simulate a dependency on other class, also to see if it handles
 * suspend function well.
 */
@Service
class FoobarServiceImpl(
    private val counterService: CounterService,
    @Value("\${app.foobar}") private val foobarStr: String
) : FoobarService {
  override fun getFoobar(): Foobar = Foobar(foobarStr)

  override suspend fun visit(request: CounterRequest): CounterResponse {
    // TODO: validate request params
    return counterService.visit(request).plusOne()
  }
}
