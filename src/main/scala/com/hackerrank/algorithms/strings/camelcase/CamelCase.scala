package com.hackerrank.algorithms.strings.camelcase

object CamelCase {
  def solution(s: String): Int = {
    s.count(c => !c.isLower) + 1
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var s = sc.next()
    println(solution(s))
  }
}

