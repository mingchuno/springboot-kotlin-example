package xyz.gutugt.springbootkotlinexample.counter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.*

/**
 * Simple unit test on service that require no DI. So I just create it directly. In reality, we will
 * usually encounter Component with dependency. Take a look on FoobarService for example.
 */
class CounterServiceTest :
    FunSpec({
      val counterService: CounterService = CounterServiceImpl()
      test("CounterService unit test") {
        val uuid = UUID.randomUUID().toString()
        counterService.visit(CounterRequest(uuid)).count.shouldBe(1)
      }
    })
