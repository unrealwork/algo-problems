package com.hackerrank.algorithms.strings

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TwoCharachtersSuite extends FunSuite {
  test("xyxyx is valid") {
    assert(TwoCharacters.isValid("xyxyx"))
  }

  test("xyxxyx is not valid") {
    assert(!TwoCharacters.isValid("xyxyyx"))
  }

  test("last duplicate chars is not valid") {
    assert(!TwoCharacters.isValid("xyxyxx"))
  }


}