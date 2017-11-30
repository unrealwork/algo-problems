
package com.hackerrank.fp.recursion

import scala.io.StdIn

object StringPermute {
  private def solve(s: String): String = {
    def listRes(list: List[Char]): List[Char] = {
      list match {
        case Nil => List()
        case left :: right :: rest => right :: left :: listRes(rest)
      }
    }

    listRes(s.toList).mkString
  }

  def main(args: Array[String]): Unit = {
    val casesCount = StdIn.readInt()
    Stream.range(0, casesCount)
      .map(_ => solve(StdIn.readLine()))
      .foreach(println)
  }
}
