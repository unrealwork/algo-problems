package com.hackerrank.fp.introduction.polygonperimeter

import scala.io.StdIn

object PolygonPerimeter {
  private def distance(p1: (Int, Int), p2: (Int, Int)): Double = {
    val dx = p1._1 - p2._1
    val dy = p1._2 - p2._2
    Math.sqrt(dx * dx + dy * dy)
  }

  def solve(points: List[(Int, Int)]): Double = {
    def perimetrAcc(currentPoint: (Int, Int), points: List[(Int, Int)], res: Double): Double = {
      if (points == Nil) {
        res
      } else {
        perimetrAcc(points.head, points.tail, res + distance(currentPoint, points.head))
      }
    }

    perimetrAcc(points.head, points.tail, distance(points.head, points.last))
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
