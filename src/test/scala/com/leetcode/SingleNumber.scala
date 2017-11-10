package com.leetcode

object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    def iter(res: Int, rest: Array[Int]): Int = {
      if (rest.isEmpty) {
        res
      } else {
        iter(res ^ rest.head, rest.tail)
      }
    }

    iter(nums.head, nums.tail)
  }
}
