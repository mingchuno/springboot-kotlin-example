package xyz.gutugt.springbootkotlinexample.counter

import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import mu.KotlinLogging
import org.springframework.stereotype.Service
import xyz.gutugt.springbootkotlinexample.http.KtorHttpClient

private val logger = KotlinLogging.logger {}

/** Simple service layer that showcase suspend function use together with Spring WebMvc */
interface CounterService {
  suspend fun visit(countRequest: CounterRequest): CounterResponse
}

/**
 * Simple service that really perform an HTTP call to external party. Note that we also add the
 * suggested component name so that later can be `@Qualifier` in test cases (esp contract test).
 * Intentionally not DI-ing the HTTP client depens here.
 */
@Service("counterService")
class CounterServiceImpl : CounterService {

  override suspend fun visit(countRequest: CounterRequest): CounterResponse {
    // Ktor HTTP Client with CIO is easy to use and require almost no setup to get JSON
    // marshalling/unmarshalling
    val response: CountApiResponse =
        KtorHttpClient.httpClient.get("https://api.countapi.xyz/hit/gutgut.xyz/${countRequest.key}")
    logger.info { response }
    return CounterResponse(count = response.value)
  }
}

@Serializable internal data class CountApiResponse(val value: Long)
