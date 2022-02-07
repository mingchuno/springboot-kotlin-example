package xyz.gutgut.springbootkotlinexample

import io.kotest.core.spec.style.ShouldSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import xyz.gutgut.springbootkotlinexample.kotest.ContractTest

/** Base class for all Contract test. Every contract test should extend this. */
@SpringBootTest(classes = [SpringbootKotlinExampleTestingApplication::class])
@ActiveProfiles("contract")
abstract class ContractTestBase : ShouldSpec() {
  init {
    tags(ContractTest)
  }
}
