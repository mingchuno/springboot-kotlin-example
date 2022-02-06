package xyz.gutugt.springbootkotlinexample

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterService
import xyz.gutugt.springbootkotlinexample.foobar.FoobarController
import xyz.gutugt.springbootkotlinexample.kotest.ApplicationTestBase

/** A simple application test case that showcase things can be Autowired even under kotest. */
class SpringbootKotlinExampleApplicationTests : ApplicationTestBase() {
  @Autowired private lateinit var foobarController: FoobarController
  init {
    "should load context" { foobarController.shouldNotBeNull() }
  }
}

/**
 * I can even Autowire MockMvc to run application/integration test. This test is not mocking
 * anything at all.
 */
@AutoConfigureMockMvc
class MockMvcApplicationTest : ApplicationTestBase() {
  @Autowired private lateinit var mockMvc: MockMvc
  init {
    "should call api" {
      mockMvc.perform(get("/visit/${UUID.randomUUID()}")).andExpect(status().isOk)
    }
  }
}

// FIXME: wrong!
@AutoConfigureMockMvc
class ApplicationTestExample : ApplicationTestBase() {
  @Autowired private lateinit var mockMvc: MockMvc
  @Autowired private lateinit var counterService: CounterService

  init {
    "test I am really using mock impl" {
      counterService.visit(CounterRequest("foobar")).count.shouldBe(1)
    }

    "should call api" {
      mockMvc.perform(get("/visit/${UUID.randomUUID()}")).andExpect(status().isOk)
    }
  }
}
