package com.hackerrank.fp.introduction.arrayofnelements

object ArrayOfNElements {
  def f(num: Int): List[Int] = {
    val list = (1 to num).toList
    println(list mkString("[",", ","]"))
    list
  }
}
