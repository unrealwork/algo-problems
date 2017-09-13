package com.hackerrank.fp.introduction.sumofoddelements

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SumOfOddElementsSuite extends FunSuite {
  test("Simple case") {
    assert(SumOfOddElements.f(List(3, 2, 4, 6, 5, 7, 8, 0, 1)) === 16)
  }

  test("Negative case") {
    assert(SumOfOddElements.f(List(11, 25, 18, -1, 26, -20, -19, 23, -24, -8)) === 39)
  }
}
