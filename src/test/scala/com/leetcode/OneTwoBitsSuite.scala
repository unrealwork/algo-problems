
package com.leetcode

import org.scalatest.FunSuite

class OneTwoBitsSuite extends FunSuite {

  test("valid sequence that end with zero") {
    Set(
      Array(1, 0, 0),
      Array(0, 0)
    ).foreach(bits =>
      assert(OneTwoBit.isOneBitCharacter(bits)))
  }

  test("invalid sequence that end with zero") {
    Set(
      Array(1, 1, 1, 0),
      Array(0, 1, 0)
    ).foreach(bits =>
      assert(!OneTwoBit.isOneBitCharacter(bits)))
  }
}
