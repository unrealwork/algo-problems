package com.hackerrank.fp.introduction.filterarray

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FilterArraySuite extends FunSuite{
  test("Simple case") {
    assert(FilterArray.f(3, List(10, 9, 8, 2, 7, 5, 1, 3, 0)) === List(2, 1, 0))
  }
}
