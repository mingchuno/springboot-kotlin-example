package xyz.gutugt.springbootkotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("xyz.gutugt.springbootkotlinexample.config")
class SpringbootKotlinExampleApplication

fun main(args: Array<String>) {
  runApplication<SpringbootKotlinExampleApplication>(*args)
}
