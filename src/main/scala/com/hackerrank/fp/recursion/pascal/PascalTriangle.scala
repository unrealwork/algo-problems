package com.hackerrank.fp.recursion.pascal

import scala.io.StdIn

object PascalTriangle {
  def solve(level: Int): List[List[Int]] = {
    def pascalAcc(step: Int, res: List[List[Int]]): List[List[Int]] = {
      if (level == step) {
        res
      } else {
        val previousLevel = res.last
        val middle = previousLevel.tail.zip(previousLevel.init).map { case (a, b) => a + b }
        pascalAcc(step + 1, res :+ ((1 :: middle) :+ 1))
      }
    }
    pascalAcc(1, List(List(1)))
  }

  def main(args: Array[String]): Unit = {
    solve(StdIn.readInt()).map(l => l.mkString(" ")).foreach(println)
  }
}
