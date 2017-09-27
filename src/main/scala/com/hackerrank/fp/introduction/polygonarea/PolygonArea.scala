package com.hackerrank.fp.introduction.polygonarea

import scala.io.StdIn

object PolygonArea {
  private def distance(p1: (Int, Int), p2: (Int, Int)): Double = {
    val dx = p1._1 - p2._1
    val dy = p1._2 - p2._2
    Math.sqrt(dx * dx + dy * dy)
  }

  def solve(points: List[(Int, Int)]): Double = {
    def areaAcc(step: Int, resAcc: Double): Double = {
      if (step < (points.size - 1)) {
        areaAcc(step + 1, resAcc + points(step)._1 * points(step + 1)._2 - points(step + 1)._1 * points(step)._2)
      } else {
        Math.abs(resAcc)
      }
    }

    1.0 / 2 * areaAcc(0, points.last._1 * points.head._2 - points.head._1 * points.last._2)
  }

  def main(args: Array[String]): Unit = {
    def point(str: String): (Int, Int) = {
      val splitted = str.split(" ")
      (splitted(0).toInt, splitted(1).toInt)
    }

    val points = (for {
      _ <- 0 until StdIn.readInt()
    } yield point(StdIn.readLine())).toList
    println(solve(points))
  }
}
