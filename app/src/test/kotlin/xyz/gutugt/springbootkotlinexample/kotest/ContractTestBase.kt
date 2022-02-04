package xyz.gutugt.springbootkotlinexample.kotest

import io.kotest.core.spec.style.ShouldSpec
import org.springframework.boot.test.context.SpringBootTest
import xyz.gutgut.springbootkotlinexample.kotest.ContractTest

@SpringBootTest
abstract class ContractTestBase : ShouldSpec() {
  init {
    tags(ContractTest)
  }
}
