package xyz.gutugt.springbootkotlinexample.counter

import org.springframework.stereotype.Service

@Service("counterServiceMock")
class CounterServiceMock : CounterService {
  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    // Always return 1 for testing!
    return CounterResponse(1)
  }
}
