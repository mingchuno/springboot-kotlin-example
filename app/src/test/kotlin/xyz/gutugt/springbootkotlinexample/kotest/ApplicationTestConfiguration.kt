package xyz.gutugt.springbootkotlinexample.kotest

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import xyz.gutugt.springbootkotlinexample.counter.CounterService
import xyz.gutugt.springbootkotlinexample.counter.CounterServiceMock

@TestConfiguration
class ApplicationTestConfiguration {
  @Bean fun counterService(): CounterService = CounterServiceMock()
}
