package xyz.gutugt.springbootkotlinexample.counter

import mu.KotlinLogging
import org.http4k.client.JettyClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

interface CounterService {
  fun visit(countRequest: CounterRequest): CounterResponse
}

@Service
class CounterServiceImpl : CounterService {
  private val jettyClient = JettyClient()

  override fun visit(countRequest: CounterRequest): CounterResponse {
    val request = Request(Method.GET, "https://api.countapi.xyz/hit/gutgut.xyz/${countRequest.key}")
    val response = jettyClient(request)
    logger.info { response }
    TODO("Not yet implemented")
  }
}
