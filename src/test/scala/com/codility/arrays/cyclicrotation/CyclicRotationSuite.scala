package com.codility.arrays.cyclicrotation

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CyclicRotationSuite extends FunSuite {
  test("Description example") {
    assert(CyclicRotation.solution(Array(3, 8, 9, 7, 6), 3) === Array(9, 7, 6, 3, 8))
    assert(CyclicRotation.solution(Array(3, 8, 9, 7, 6), 0) === Array(3, 8, 9, 7, 6))
    assert(CyclicRotation.solution(Array(), 3) === Array())
  }
}
