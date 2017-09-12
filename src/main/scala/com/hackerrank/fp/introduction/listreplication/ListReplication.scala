package com.hackerrank.fp.introduction.listreplication

object ListReplication {
  def f(num: Int, arr: List[Int]): List[Int] =
    arr.flatMap(n => for (_ <- 0 until num) yield n)
}
