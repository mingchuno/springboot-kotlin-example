package xyz.gutugt.springbootkotlinexample

import io.kotest.matchers.nulls.shouldNotBeNull
import java.util.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import xyz.gutugt.springbootkotlinexample.foobar.FoobarController

/** JUnit style test with spring context loading */
@SpringBootTest
class SpringbootKotlinExampleApplicationTests {
  @Autowired private lateinit var foobarController: FoobarController
  @Test
  fun contextLoads() {
    foobarController.shouldNotBeNull()
  }
}

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTest {
  @Autowired private lateinit var mockMvc: MockMvc

  @Test
  fun shouldCallApi() {
    this.mockMvc.perform(get("/visit/${UUID.randomUUID()}")).andExpect(status().isOk)
  }
}
