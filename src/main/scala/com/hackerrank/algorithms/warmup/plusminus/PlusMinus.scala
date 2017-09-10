package com.hackerrank.algorithms.warmup.plusminus

import PlusMinus.Sign.{Negative, Positive, Sign, Zero}
import java.util.Scanner

/**
  * Given an array of integers, calculate which fraction
  * of its elements are positive, which fraction of its
  * elements are negative, and which fraction of its elements
  * are zeroes, respectively.
  *
  * Print the decimal value of each fraction on a new line.
  */
object PlusMinus {

  object Sign extends Enumeration {
    type Sign = Value
    val Positive, Negative, Zero = Value
  }

  def solution(nums: Array[Int]): Map[Sign, String] = {
    def condPercent(f: (Int => Boolean)): String = {
      format((nums count f).toDouble / nums.length.toDouble)
    }

    def format(d: Double): String = {
      f"$d%.6f"
    }

    Map(
      Positive -> condPercent(num => num > 0),
      Negative -> condPercent(num => num < 0),
      Zero -> condPercent(num => num == 0)
    )
  }

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val arr = (for (_ <- 0 until n) yield sc.nextInt) toArray
    val res = solution(arr)
    val formattedResult = List(Positive, Negative, Zero)
      .map(res)
      .mkString(f"%n")
    println(formattedResult)
  }
}
