package xyz.gutugt.springbootkotlinexample.counter

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.shouldSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import java.util.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.gutugt.springbootkotlinexample.foobar.FoobarService

@SpringBootTest
class CounterServiceContractTest : ShouldSpec() {

  //  @Autowired private lateinit var counterServiceActual: CounterService
  //  @Qualifier("counterServiceMock")
  @Autowired private lateinit var counterServiceMock: CounterService

  init {
    should("not null") { counterServiceMock.shouldNotBeNull() }
    //    include(counterServiceContractTest(counterServiceActual))
    //    include(counterServiceContractTest(counterServiceMock))
  }
}

private fun counterServiceContractTest(counterService: CounterService) = shouldSpec {
  should("CounterService return value") {
    counterService.visit(CounterRequest("foobar")).count.shouldBeGreaterThan(0)
  }
}

@SpringBootTest
class XXXContractTest {

  @Autowired private lateinit var counterServiceMock: CounterService

  @Test
  fun `no null`() {
    counterServiceMock.shouldNotBeNull()
  }
}

@SpringBootTest
class FoobarServiceTestWithSpringMockkaaaaa : StringSpec() {
  @Autowired private lateinit var foobarService: FoobarService
  @MockkBean private lateinit var counterService: CounterService
  init {
    "FoobarService test" {
      coEvery { counterService.visit(any()) } returns CounterResponse(1)
      foobarService.visit(CounterRequest(UUID.randomUUID().toString())).count.shouldBe(2)
    }
  }
}
