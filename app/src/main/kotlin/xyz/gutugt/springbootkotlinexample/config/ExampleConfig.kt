package xyz.gutugt.springbootkotlinexample.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app.example")
data class ExampleConfig(val name: String, val age: Int, val enable: Boolean)
