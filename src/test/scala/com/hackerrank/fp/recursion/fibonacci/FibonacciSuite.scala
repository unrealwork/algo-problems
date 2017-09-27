package com.hackerrank.fp.recursion.fibonacci

import org.scalatest.FunSuite

class FibonacciSuite extends FunSuite {

  test ("Simle case"){
    assert(Fibonacci.fibonacci(0) === 0)
    assert(Fibonacci.fibonacci(1) === 0)
    assert(Fibonacci.fibonacci(2) === 0)
    assert(Fibonacci.fibonacci(3) === 1)
    assert(Fibonacci.fibonacci(4) === 2)
    assert(Fibonacci.fibonacci(5) === 3)
  }
}
