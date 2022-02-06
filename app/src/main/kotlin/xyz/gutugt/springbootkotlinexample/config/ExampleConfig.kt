package xyz.gutugt.springbootkotlinexample.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/** Example Spring Properties that load into a data class instead of plain @Value */
@ConstructorBinding
@ConfigurationProperties(prefix = "app.example")
data class ExampleConfig(val name: String, val age: Int, val enable: Boolean)
