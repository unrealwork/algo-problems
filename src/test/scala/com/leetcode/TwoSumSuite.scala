package com.leetcode

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class TwoSumSuite extends FunSuite {
  test("Description's case") {
    assert(TwoSum.twoSum(Array(2, 7, 11, 15), 9) === Array(0, 1))
  }
}
