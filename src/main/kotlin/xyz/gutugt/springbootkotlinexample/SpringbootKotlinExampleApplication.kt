package xyz.gutugt.springbootkotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootKotlinExampleApplication

fun main(args: Array<String>) {
	runApplication<SpringbootKotlinExampleApplication>(*args)
}
