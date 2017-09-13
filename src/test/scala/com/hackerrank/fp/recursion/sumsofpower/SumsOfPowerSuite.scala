package com.hackerrank.fp.recursion.sumsofpower


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SumsOfPowerSuite extends FunSuite {
  test("Description case 1") {
    assert(SumsOfPower.solve(100, 2) === 3)
  }

  test("Description case 2") {
    assert(SumsOfPower.solve(10, 2) === 1)
  }

  test("Description case 3") {
    assert(SumsOfPower.solve(100, 3) === 1)
  }

  test("Timeout case 3") {
    assert(SumsOfPower.solve(800, 2) === 561)
  }

  test("Log 1000 2") {
    assert(SumsOfPower.limit(2,1000) === 32)
  }
}
