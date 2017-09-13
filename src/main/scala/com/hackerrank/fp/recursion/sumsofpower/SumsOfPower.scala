package com.hackerrank.fp.recursion.sumsofpower

import scala.io.StdIn

object SumsOfPower {
  def limit(b: Int, a: Int):Int = {
    def logAcc(b: Int, previous:Int):Int = {
      if (Math.pow(previous,b).toInt > a ) {
        previous
      } else {
        logAcc(b, previous + 1)
      }
    }
    logAcc(b, 1)
  }

  def solve(desire: Int, pow: Int):Int = {
    val l = limit(pow, desire)
    def solveAcc(sumAcc: Int, currentMember: Int): Int = {
      val newSum = sumAcc + Math.pow(currentMember, pow).toInt
      if (newSum == desire) {
        1
      } else {
        if (newSum > desire) {
          0
        } else {
          // TODO: limit only diff
          (for (n <- Stream.range(currentMember + 1, l)) yield solveAcc(newSum, n)) sum
        }
      }
    }

    (for (n <- Stream.range(1, l)) yield solveAcc(0, n)) sum
  }

  def main(args: Array[String]): Unit = {
    println(solve(StdIn.readInt(), StdIn.readInt()))
  }
}
