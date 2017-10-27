package com.codility.timecomplexity

import scala.annotation.tailrec

object MissingPermutationElem {
  def solution(a: Array[Int]): Int = {
    @tailrec
    def findMissingElem(a: Array[Int], curIndex: Int, res: Int): Int = {
      if (curIndex == a.length) {
        res + curIndex + 1
      } else {
        findMissingElem(a, curIndex + 1, res + curIndex + 1 - a(curIndex))
      }
    }
    findMissingElem(a, 0, 0)
  }
}
