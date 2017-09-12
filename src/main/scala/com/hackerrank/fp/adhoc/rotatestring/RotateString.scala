package com.hackerrank.fp.adhoc.rotatestring

import scala.io.StdIn

object RotateString {
  def rotation(s: String): List[String] = {
    def rotateAcc(accRes: List[String], movingChar: Char, startPart: String): List[String] = {
      val newRotation = startPart + movingChar
      if (accRes.size == s.length - 1) {
        accRes :+ newRotation
      } else {
        rotateAcc(accRes :+ newRotation, newRotation.head, newRotation.tail)
      }
    }

    rotateAcc(List(), s.head, s.tail)
  }

  def solve(arr: List[String]): List[List[String]] = arr map rotation

  def main(args: Array[String]): Unit = {
    var arr = (for (_ <- 0 until StdIn.readInt) yield StdIn.readLine)
      .toList
    solve(arr).foreach(list => println(list mkString " "))
  }
}
