package com.hackerrank.algorithms.strings.camelcase

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CamelCaseSuite extends FunSuite {
  test("saveChangesInTheEditor contains 5 word") {
    assert(CamelCase.solution("saveChangesInTheEditor") === 5)
  }
}
