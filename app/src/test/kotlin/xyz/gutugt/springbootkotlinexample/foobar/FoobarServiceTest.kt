package xyz.gutugt.springbootkotlinexample.foobar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import java.util.*
import org.springframework.boot.test.context.SpringBootTest
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

/** This example do not mock the underlying CounterService which is usually not what we want */
// FIXME: use @ContextConfiguration instead?
@SpringBootTest
class FoobarServiceTestWithoutMock(private val foobarService: FoobarService) :
    FunSpec({
      test("FoobarService test") {
        val uuid = UUID.randomUUID().toString()
        foobarService.visit(CounterRequest(uuid)).count.shouldBe(2)
      }
    })

/**
 * This example use plain old mockk to mock the dependency we want. It works when we have simple
 * dependency graph but will fail when we have complex dependency structure which we want to mock
 * some part of it but not another part.
 */
class FoobarServiceTestWithMock :
    BehaviorSpec({
      val counterService = mockk<CounterService>()
      val foobarService = FoobarServiceImpl(counterService)
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
    })
