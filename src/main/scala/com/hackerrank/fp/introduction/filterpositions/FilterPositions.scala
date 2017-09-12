package com.hackerrank.fp.introduction.filterpositions

object FilterPositions {
  def f(arr: List[Int]): List[Int] = {
    arr.zipWithIndex.filter {
      case (_, i) => i % 2 == 1
    }.map {
      case (e, _) => e
    }
  }
}
