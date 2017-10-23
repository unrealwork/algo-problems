package com.hackerrank.fp.recursion.stringmingling

import scala.io.StdIn

object StringMingling {

  def solve(s: String, t: String): String = {
    s.zip(t).map(s => s"${s._1}${s._2}").foldLeft(new StringBuilder) {
      (sb, s) => sb append s
    }.toString
  }

  def main(args: Array[String]) = {
    println(solve(StdIn.readLine(), StdIn.readLine()))
  }
}
