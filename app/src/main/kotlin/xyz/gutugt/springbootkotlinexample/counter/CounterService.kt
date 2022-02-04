package xyz.gutugt.springbootkotlinexample.counter

import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import mu.KotlinLogging
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import xyz.gutugt.springbootkotlinexample.http.KtorHttpClient

private val logger = KotlinLogging.logger {}

interface CounterService {
  suspend fun visit(countRequest: CounterRequest): CounterResponse
}

/** Simple service that really perform an HTTP call to external party */
@Service("counterService")
@Primary
class CounterServiceImpl : CounterService {

  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    val response: CountApiResponse =
        KtorHttpClient.httpClient.get("https://api.countapi.xyz/hit/gutgut.xyz/${countRequest.key}")
    logger.info { response }
    return CounterResponse(count = response.value)
  }
}

@Serializable internal data class CountApiResponse(val value: Long)
