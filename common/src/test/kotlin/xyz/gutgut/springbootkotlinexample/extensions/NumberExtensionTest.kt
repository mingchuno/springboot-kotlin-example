package xyz.gutgut.springbootkotlinexample.extensions

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class NumberExtensionTest :
    FunSpec({
      test("1 + 1 should be 2") {
        // Demo simple property test
        checkAll<Int> { int -> int.plusOne().shouldBe(int + 1) }
      }
    })
