package xyz.gutugt.springbootkotlinexample.foobar

import org.springframework.stereotype.Service

interface FoobarService {
  fun getFoobar(): Foobar
}

@Service
class FoobarServiceImpl : FoobarService {
  override fun getFoobar(): Foobar = Foobar("bar")
}
