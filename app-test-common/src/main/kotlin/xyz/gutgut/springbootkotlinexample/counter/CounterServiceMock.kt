package xyz.gutgut.springbootkotlinexample.counter

import mu.KotlinLogging
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import xyz.gutugt.springbootkotlinexample.counter.CounterRequest
import xyz.gutugt.springbootkotlinexample.counter.CounterResponse
import xyz.gutugt.springbootkotlinexample.counter.CounterService

private val logger = KotlinLogging.logger {}

/**
 * This is the mock implementation of the CounterService that can be used in Application test and it
 * should be verified in Contract test. **Important:** Since we reduce boilerplate using spring boot
 * auto component scan and `@TestConfiguration` and `@ContextConfiguration` introduce boilerplate
 * and not even work with kotest(?). So `@Primary` and `@ActiveProfile` should be the easiest way to
 * work with. Every mock component impl show mark with these 2 annotations.
 */
@Service("counterServiceMock")
@Primary
@Profile("contract", "application")
class CounterServiceMock : CounterService {
  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    // Always return 1 for testing!
    logger.info { "Using CounterService mock impl!" }
    return CounterResponse(1)
  }
}
