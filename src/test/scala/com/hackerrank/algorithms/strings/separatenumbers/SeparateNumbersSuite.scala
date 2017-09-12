package com.hackerrank.algorithms.strings.separatenumbers

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SeparateNumbersSuite extends FunSuite {
  test("1234 can be separated") {
    assert(SeparateNumbers.isCanSeparate("1234").contains(1))
  }

  test("91011 can be separated") {
    assert(SeparateNumbers.isCanSeparate("91011").contains(9))
  }

  test("99100 can be separated") {
    assert(SeparateNumbers.isCanSeparate("99100").contains(99))
  }

  test("010203 can not be separated") {
    assert(SeparateNumbers.isCanSeparate("010203").isEmpty)
  }


}
