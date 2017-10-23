package com.codility.arrays.oddoccurrences

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class OddOccurrencesSuite extends FunSuite {
  test("Description's sample") {
    assert(OddOccurences.solution(Array(1, 2, 1)) === 2)
  }
}
