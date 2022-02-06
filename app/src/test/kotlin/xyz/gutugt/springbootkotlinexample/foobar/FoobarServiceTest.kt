package xyz.gutugt.springbootkotlinexample.foobar

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.gutugt.springbootkotlinexample.config.ExampleConfig
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

/** This example do not mock the underlying CounterService which is usually not what we want */
@SpringBootTest
class FoobarServiceTestWithSpringBootTest(private val foobarService: FoobarService) :
    FunSpec({
      test("FoobarService visit test") {
        val uuid = UUID.randomUUID().toString()
        foobarService.visit(CounterRequest(uuid)).count.shouldBe(2)
      }

      test("FoobarService getFoobar test") { foobarService.getFoobar().foobar.shouldBe("42") }
    })

/**
 * This example use plain old mockk to mock the dependency we want. It works when we have simple
 * dependency graph but will fail when we have complex dependency structure which we want to mock
 * some part of it but not another part.
 */
class FoobarServiceTestWithMockk :
    BehaviorSpec({
      val counterService = mockk<CounterService>()
      val exampleConfig = mockk<ExampleConfig>()
      val foobarString = "Can we move it to some where else?"
      val foobarService = FoobarServiceImpl(counterService, exampleConfig, foobarString)

      afterContainer { clearAllMocks() }

      given("CountService always return 1") {
        val uuid = UUID.randomUUID().toString()
        coEvery { counterService.visit(eq(CounterRequest(uuid))) }.returns(CounterResponse(1))

        When("Calling FoobarService visit") {
          val resp = foobarService.visit(CounterRequest(uuid))

          Then("Response should be 2") { resp.count.shouldBe(2) }

          Then("CountService should be call with") {
            coVerify(exactly = 1) { counterService.visit(any()) }
          }
        }
      }

      given("Setup are ready") {
        When("Calling FoobarService.getFoobar") {
          val resp = foobarService.getFoobar()

          Then("Should return the mock value") { resp.foobar.shouldBe(foobarString) }
        }
      }
    })

/**
 * This unit test use mockk to mock the underlying depns "on the scene" instead of using mock impl.
 */
@SpringBootTest
class FoobarServiceTestWithSpringMockk : StringSpec() {
  @Autowired private lateinit var foobarService: FoobarService
  @MockkBean private lateinit var counterService: CounterService
  init {
    "FoobarService test" {
      coEvery { counterService.visit(any()) } returns CounterResponse(1)
      foobarService.visit(CounterRequest(UUID.randomUUID().toString())).count.shouldBe(2)
    }
  }
}
