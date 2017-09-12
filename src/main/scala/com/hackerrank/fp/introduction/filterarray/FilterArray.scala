package com.hackerrank.fp.introduction.filterarray

object FilterArray {
  def f(delim: Int, arr: List[Int]): List[Int] = arr filter (e => e < delim)
}
