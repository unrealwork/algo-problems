package com.leetcode

object TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    def iter (index: Int, map: Map[Int, Int]): Array[Int] = {
      if (index == nums.length) {
        throw new IllegalArgumentException
      } else {
        val elem = nums(index)
        val secTerm = target - elem
        if (map.contains(secTerm)) {
          Array(map(secTerm), index)
        } else {
          iter(index + 1, map + (elem -> index))
        }
      }
    }

    iter(0, Map())
  }
}
