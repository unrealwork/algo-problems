package com.hackerrank.fp.introduction.sumofoddelements

object SumOfOddElements {
  def f(arr: List[Int]): Int = arr
    .filter(e => e.abs % 2 == 1)
    .sum
}
