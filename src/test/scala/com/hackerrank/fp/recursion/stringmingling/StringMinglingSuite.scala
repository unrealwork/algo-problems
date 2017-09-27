package com.hackerrank.fp.recursion.stringmingling

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringMinglingSuite extends FunSuite {
  test("Simple") {
    assert(StringMingling.solve("abcde", "pqrst") === "apbqcrdset")
  }
}
