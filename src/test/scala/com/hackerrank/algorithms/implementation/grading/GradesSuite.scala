package com.hackerrank.algorithms.implementation.grading

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GradesSuite extends FunSuite {
  test("Correct score: diff less 3") {
    assert(Grading.correctedGrade(68) === 70)
  }

  test("Correct score: diff equals 3") {
    assert(Grading.correctedGrade(42) === 42)
  }

  test("Correct score: diff more 3") {
    assert(Grading.correctedGrade(41) === 41)
  }

  test("Description example") {
    assert(Grading.solution(Array(73, 67, 38, 33)) === Array(75, 67, 40, 33))
  }
}
