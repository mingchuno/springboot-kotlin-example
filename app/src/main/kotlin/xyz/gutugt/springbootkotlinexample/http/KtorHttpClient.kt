package xyz.gutugt.springbootkotlinexample.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*

object KtorHttpClient {
  val httpClient: HttpClient = HttpClient(CIO) { install(JsonFeature) }
}
