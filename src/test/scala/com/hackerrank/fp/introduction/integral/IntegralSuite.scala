package com.hackerrank.fp.introduction.integral

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IntegralSuite extends FunSuite {
  val Margin = 1e-1
  test("area: simple case") {
    val coefs = List(1, 2, 3, 4, 5)
    val powers = List(6, 7, 8, 9, 10)
    val int = Integral.summation(Integral.f, 4, 1, coefs, powers)
    assert(Math.abs(int - 2435300.3) < Margin)
  }
}
