package xyz.gutugt.springbootkotlinexample.counter

import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import mu.KotlinLogging
import org.springframework.stereotype.Service
import xyz.gutgut.springbootkotlinexample.extensions.plusOne
import xyz.gutugt.springbootkotlinexample.http.KtorHttpClient

private val logger = KotlinLogging.logger {}

interface CounterService {
  suspend fun visit(countRequest: CounterRequest): CounterResponse
}

@Service
class CounterServiceImpl : CounterService {

  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    val response: CountApiResponse =
        KtorHttpClient.httpClient.get("https://api.countapi.xyz/hit/gutgut.xyz/${countRequest.key}")
    logger.info { response }
    // Demo app depends on lib using `plusOne` function
    return CounterResponse(count = response.value.plusOne())
  }
}

@Serializable internal data class CountApiResponse(val value: Long)
