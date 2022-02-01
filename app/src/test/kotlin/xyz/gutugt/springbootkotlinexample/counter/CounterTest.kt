package xyz.gutugt.springbootkotlinexample.counter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/** Simple unit test showcase */
class CounterTest :
    FunSpec({
      test("CounterRequest") {
        val key = "key"
        CounterRequest(key).key.shouldBe(key)
      }

      test("CounterResponse") {
        val count = 1L
        CounterResponse(count).count.shouldBe(count)
      }
    })
