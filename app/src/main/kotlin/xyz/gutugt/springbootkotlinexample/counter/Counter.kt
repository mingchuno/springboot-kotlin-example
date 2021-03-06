package xyz.gutugt.springbootkotlinexample.counter

import arrow.optics.optics
import xyz.gutgut.springbootkotlinexample.extensions.plusOne

data class CounterRequest(val key: String)

/** I don't really need optics here. Just showcase */
@optics
data class CounterResponse(val count: Long) {
  companion object

  /** Showcase :app depends on :common using `plusOne` function */
  fun plusOne(): CounterResponse = copy(count = count.plusOne())
}
