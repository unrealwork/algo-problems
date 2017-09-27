package com.hackerrank.fp.recursion.fibonacci

object Fibonacci {

  def fibonacci(x: Int): Int = {
    if (x < 3) {
      0
    } else {
      if (x < 5) {
        x - 2
      } else {
        fibonacci(x - 2) + fibonacci(x - 1)
      }
    }
  }

  def main(args: Array[String]) {
    /** This will handle the input and output **/
    println(fibonacci(readInt()))

  }
}
