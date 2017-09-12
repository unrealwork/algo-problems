package com.hackerrank.algorithms.strings.pangrams

import scala.io.StdIn

object Pangrams {
  def solve(s: String): Boolean = {
    val AlphabetSize = 26
    val charSet = s.map(c => c.toLower)
      .toSet
      .filter(c => c.isLetter)
    charSet.size == AlphabetSize
  }

  def main(args: Array[String]): Unit = {
    val s = StdIn.readLine()
    if (solve(s)) {
      println("pangram")
    } else {
      println("not pangram")
    }
  }
}
