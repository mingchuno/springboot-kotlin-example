package xyz.gutugt.springbootkotlinexample.counter

import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

/**
 * This is the mock implementation of the CounterService that can be used in Application test and it
 * should be verified in Contract test.
 */
@Service("counterServiceMock")
class CounterServiceMock : CounterService {
  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    // Always return 1 for testing!
    logger.info { "Using CounterService mock impl!" }
    return CounterResponse(1)
  }
}
