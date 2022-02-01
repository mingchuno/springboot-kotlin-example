package xyz.gutgut.springbootkotlinexample.kotest

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.core.test.AssertionMode
import io.kotest.extensions.htmlreporter.HtmlReporter
import io.kotest.extensions.junitxml.JunitXmlReporter

abstract class CommonProjectConfig : AbstractProjectConfig() {
  override val parallelism = 3
  override val assertionMode = AssertionMode.Warn
  override val globalAssertSoftly = true
  override fun extensions(): List<Extension> =
      listOf(JunitXmlReporter(includeContainers = false, useTestPathAsName = true), HtmlReporter())
}
