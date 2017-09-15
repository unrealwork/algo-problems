package com.hackerrank.fp.introduction.functionornot

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionOrNotSuite extends FunSuite {
  test("fun suite: YES") {
    val pointsSet = List(
      List(
        (1, 1),
        (2, 2),
        (3, 3)
      )
    )
    assert(FunctionOrNot.solve(pointsSet) === List(true))
  }

  test("fun suite: NO") {
    val pointsSet = List(
      List(
        (1, 1),
        (2, 2),
        (2, 3),
        (3, 3)
      )
    )
    assert(FunctionOrNot.solve(pointsSet) === List(false))
  }
}
