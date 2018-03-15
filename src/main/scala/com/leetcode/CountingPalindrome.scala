
package com.leetcode

object CountingPalindrome {
  def countSubstrings(s: String): Int = {
    val dict: Map[Char, Int] = s.groupBy(_.toChar).map(p => (p._1, p._2.length))
    0
  }

  def main(args: Array[String]): Unit = {
    countSubstrings("abc")
  }
}
