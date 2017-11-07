package com.leetcode

import scala.math.max

object LongestSubsequence {
  def lengthOfLongestSubstring(s: String): Int = {
    def iter(i: Int, res: Int, set: Map[Char, Int]): Int = {
      if (i == s.length) {
        max(res, set.size)
      } else {
        if (set.contains(s(i))) {
          val previousOccIndex = set(s(i))
          val nextMap = set.filter(_._2 > previousOccIndex)
          iter(i + 1, max(res, set.size), nextMap + (s(i) -> i))
        } else {
          iter(i + 1, res, set + (s(i) -> i))
        }
      }
    }

    iter(0, 0, Map())
  }
}
