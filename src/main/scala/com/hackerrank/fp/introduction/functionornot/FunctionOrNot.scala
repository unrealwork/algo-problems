package com.hackerrank.fp.introduction.functionornot

import scala.io.StdIn

object FunctionOrNot {


  def solve(pointsSet: List[List[(Int, Int)]]): List[Boolean] = {
    pointsSet map (points => points.toMap.size == points.size)
  }

  def main(args: Array[String]) {
    val t = StdIn.readLine.trim.toInt
    val pointsSet = (0 until t).map(_ => {
      val n = StdIn.readLine.trim.toInt
      (0 until n).map(_ => {
        val nums: Array[Int] = StdIn.readLine().split(" ").map(s => s.toInt)
        (nums(0), nums(1))
      }).toList
    }).toList

    for (r <- solve(pointsSet)) {
      if (r)
        println("YES")
      else
        println("NO")
    }
  }
}
