package xyz.gutgut.springbootkotlinexample.kotest

import io.kotest.core.extensions.Extension
import io.kotest.extensions.spring.SpringExtension

abstract class SpringProjectConfig : CommonKotestProjectConfig() {
  override fun extensions(): List<Extension> {
    return super.extensions() + SpringExtension
  }
}
