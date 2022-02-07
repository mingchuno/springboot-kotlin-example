package xyz.gutgut.springbootkotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
// @ComponentScan(basePackages = ["xyz.gutugt.springbootkotlinexample"], lazyInit = true)
@ConfigurationPropertiesScan("xyz.gutugt.springbootkotlinexample.config")
class SpringbootKotlinExampleTestingApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
  runApplication<SpringbootKotlinExampleTestingApplication>(*args)
}
