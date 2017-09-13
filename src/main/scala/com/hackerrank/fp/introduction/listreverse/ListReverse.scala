package com.hackerrank.fp.introduction.listreverse

object ListReverse {
  def f(arr: List[Int]): List[Int] = {
    def reverse(arr: List[Int], reverseRes: List[Int]):List[Int] = arr match {
      case x :: tail => reverse(arr.tail, arr.head :: reverseRes)
      case Nil => reverseRes
    }
    reverse(arr, List.empty)
  }
}
