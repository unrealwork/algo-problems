package com.hackerrank.algorithms.strings.pangrams

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PangramSuite extends FunSuite {
  test("Description example: pangram") {
    assert(Pangrams.solve("We promptly judged antique ivory buckles for the next prize"))
  }

  test("Description example: not pangram") {
    assert(!Pangrams.solve("pangram"))
  }
}
