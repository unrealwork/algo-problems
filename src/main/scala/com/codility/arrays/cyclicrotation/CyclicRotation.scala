package com.codility.arrays.cyclicrotation

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    def rotate(currentIndex: Int, shift: Int, array: Array[Int], res: Array[Int]): Array[Int] = {
      if (currentIndex == a.length) {
        res
      } else {
        res((currentIndex + shift) % array.length) = array(currentIndex)
        rotate(currentIndex + 1, shift, a, res)
      }
    }

    rotate(0, normalizedShift(k, a.length), a, new Array[Int](a.length))
  }

  private def normalizedShift(shift: Int, size: Int) = {
    if (size != 0) {
      shift % size
    } else {
      shift
    }
  }
}
