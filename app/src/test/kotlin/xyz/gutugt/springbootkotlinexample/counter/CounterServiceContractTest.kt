package xyz.gutugt.springbootkotlinexample.counter

import io.kotest.matchers.longs.shouldBeGreaterThan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import xyz.gutugt.springbootkotlinexample.kotest.ContractTestBase

/**
 * Somehow kotest factory is not working with Spring DI ... So I have to resolve to this style of
 * writing.
 */
abstract class CounterServiceContractTest : ContractTestBase() {

  protected abstract val counterService: CounterService

  init {
    should("CounterService contract test return value") {
      counterService.visit(CounterRequest("foobar")).count.shouldBeGreaterThan(0)
    }
  }
}

/**
 * In these example, you can see I use `@Qualifier` to choose what to be injected into the test case
 * exactly.
 */
class CounterServiceMockTest : CounterServiceContractTest() {
  @Qualifier("counterServiceMock") @Autowired override lateinit var counterService: CounterService
}

class CounterServiceActualTest : CounterServiceContractTest() {
  @Qualifier("counterService") @Autowired override lateinit var counterService: CounterService
}
