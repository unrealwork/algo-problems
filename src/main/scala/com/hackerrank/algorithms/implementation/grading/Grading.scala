
package com.hackerrank.algorithms.implementation.grading

object Grading {
  val NotModifyDiffEdge = 38
  val DiffEdge = 3

  def correctedGrade(grade: Int): Int = {
    if (grade % 5 == 0 || grade < NotModifyDiffEdge) {
      grade
    } else {
      val nextScore = (grade / 5 + 1) * 5
      val diff = nextScore - grade
      if (diff < DiffEdge)
        nextScore
      else
        grade
    }
  }

  def solution(array: Array[Int]): Array[Int] = {
    array map correctedGrade
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var n = sc.nextInt()
    var grades = {
      for {
        grades_i <- 0 until n
      } yield sc.nextInt
    }.toArray
    val lineSeparator = System.lineSeparator()
    println(solution(grades) mkString lineSeparator)
  }
}
