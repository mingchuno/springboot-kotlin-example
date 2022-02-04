package xyz.gutugt.springbootkotlinexample.counter

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service("counterServiceMock")
@Primary
class CounterServiceMock : CounterService {
  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    // Always return 1 for testing!
    return CounterResponse(1)
  }
}
