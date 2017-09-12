package com.hackerrank.fp.introduction.filterpositions

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FilterPositionsSuite extends FunSuite {
  test("Description example") {
    assert(FilterPositions.f(List(2, 5, 3, 4, 6, 7, 9, 8)) === List(5, 4, 7, 8))
  }
}
