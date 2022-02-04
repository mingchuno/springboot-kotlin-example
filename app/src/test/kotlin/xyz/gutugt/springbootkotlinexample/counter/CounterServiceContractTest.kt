package xyz.gutugt.springbootkotlinexample.counter

import io.kotest.matchers.longs.shouldBeGreaterThan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import xyz.gutugt.springbootkotlinexample.kotest.ContractTestBase

/** Somehow kotest factor is not working with Spring DI ... So I have to resolve to this style. */
abstract class CounterServiceContractTest : ContractTestBase() {

  protected abstract val counterService: CounterService

  init {
    should("CounterService contract test return value") {
      counterService.visit(CounterRequest("foobar")).count.shouldBeGreaterThan(0)
    }
  }
}

class CounterServiceMockTest : CounterServiceContractTest() {
  @Qualifier("counterServiceMock") @Autowired override lateinit var counterService: CounterService
}

class CounterServiceActualTest : CounterServiceContractTest() {
  @Qualifier("counterService") @Autowired override lateinit var counterService: CounterService
}
