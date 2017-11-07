package com.leetcode

object SumOfTwo {
  def getSum(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      getSum(a ^ b, (a & b) << 1)
    }
  }
}
