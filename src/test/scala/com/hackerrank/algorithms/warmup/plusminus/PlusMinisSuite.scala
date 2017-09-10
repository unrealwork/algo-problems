package com.hackerrank.algorithms.warmup.plusminus

import com.hackerrank.algorithms.warmup.plusminus.PlusMinus.Sign
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class PlusMinisSuite extends FunSuite {
  test("Description exmaple: -4, 3, -9, 0, 4, 1") {
    val nums = Array(-4, 3, -9, 0, 4, 1)
    val expectedResult = Map(
      Sign.Positive -> "0.500000",
      Sign.Negative -> "0.333333",
      Sign.Zero -> "0.166667"
    )
    val actualResult = PlusMinus.solution(nums)
    assert(actualResult === expectedResult)
  }
}
