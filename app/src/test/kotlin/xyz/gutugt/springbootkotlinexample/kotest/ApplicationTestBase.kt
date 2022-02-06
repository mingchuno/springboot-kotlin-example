package xyz.gutugt.springbootkotlinexample.kotest

import io.kotest.core.spec.style.StringSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import xyz.gutgut.springbootkotlinexample.kotest.ApplicationTest

/** Base class for all Application test. Every application test should extend this. */
@SpringBootTest
@ActiveProfiles("application")
abstract class ApplicationTestBase : StringSpec() {
  init {
    tags(ApplicationTest)
  }
}
