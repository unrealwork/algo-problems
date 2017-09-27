package com.hackerrank.fp.introduction.polygonarea

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PolygonAreaSuite extends FunSuite {
  test("Simple case") {
    val points = List(
      (0, 0),
      (0, 1),
      (1, 1),
      (1, 0))
    assert(PolygonArea.solve(points) === 1)
  }
}
