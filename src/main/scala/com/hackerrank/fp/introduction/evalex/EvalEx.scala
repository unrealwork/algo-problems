package com.hackerrank.fp.introduction.evalex

import scala.io.StdIn

object EvalEx {
  def exp(x: Double): Double = {
    def Eps = 1e-6

    def expAcc(accValue: Double, previousMember: Double, step: Int): Double = {
      if (step == 10) {
        accValue
      } else {
        expAcc(accValue + previousMember * x / step, previousMember * x / step, step + 1)
      }
    }

    expAcc(1d, 1d, 1)
  }

  def solve(arr: IndexedSeq[Double]) = arr map exp

  def main(args: Array[String]) {
    val arr = for (_ <- 0 until StdIn.readInt) yield StdIn.readDouble
    solve(arr).foreach(y => println("%.4f".format(y)))
  }
}
