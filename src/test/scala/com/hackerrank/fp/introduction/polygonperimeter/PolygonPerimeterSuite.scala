package com.hackerrank.fp.introduction.polygonperimeter

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PolygonPerimeterSuite extends FunSuite {
  test("Simple case") {
    val points = List(
      (0, 0),
      (0, 1),
      (1, 1),
      (1, 0))
    assert(PolygonPerimeter.solve(points) === 4)
  }
}
