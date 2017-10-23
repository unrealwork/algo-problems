package com.hackerrank.fp.recursion.pascal

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalTriangleSuite extends FunSuite {
  test("Simple") {
    assert(PascalTriangle.solve(3) === List(
      List(1),
      List(1, 1),
      List(1, 2, 1)
    ))
  }
}
