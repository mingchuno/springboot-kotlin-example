package xyz.gutugt.springbootkotlinexample.foobar

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.mockk.coEvery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse

@SpringBootTest
@AutoConfigureMockMvc
class FoobarControllerTest : StringSpec() {
  @Autowired private lateinit var mockMvc: MockMvc
  @Autowired private lateinit var foobarController: FoobarController
  @MockkBean private lateinit var foobarService: FoobarService
  init {
    "Should load Spring Application Context" { foobarController.shouldNotBeNull() }
    "Should call and return from foobarService" {
      coEvery { foobarService.visit(any()) } returns CounterResponse(1)
      mockMvc.perform(get("/visit/foobar")).andDo(print()).andExpect(status().isOk)
    }
  }
}
