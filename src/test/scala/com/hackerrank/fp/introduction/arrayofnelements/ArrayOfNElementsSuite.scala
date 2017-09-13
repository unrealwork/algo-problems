package com.hackerrank.fp.introduction.arrayofnelements

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ArrayOfNElementsSuite extends FunSuite {
  test("Description example") {
    assert(ArrayOfNElements.f(3) == List(1, 2, 3))
  }
}
