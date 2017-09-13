package com.hackerrank.fp.introduction.listreverse

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListReverseSuite extends FunSuite {
  test("Description Example") {
    assert(ListReverse.f(List(1, 2, 3)) === List(3, 2, 1))
  }
}
