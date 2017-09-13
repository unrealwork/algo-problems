package com.hackerrank.fp.introduction.evalex

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EvalExSuite extends FunSuite {
  val Precision = 1e-1
  test("Description e^20") {
    lazy val expectedValue = 2423600.1887d
    assert((EvalEx.exp(20) - expectedValue).abs < Precision)
  }
}
