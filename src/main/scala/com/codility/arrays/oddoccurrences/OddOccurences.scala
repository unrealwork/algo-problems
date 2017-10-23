package com.codility.arrays.oddoccurrences

object OddOccurences {
  def solution(a: Array[Int]): Int = {
    a.foldLeft(0)((res, cur) => {
      res ^ cur
    })
  }
}
