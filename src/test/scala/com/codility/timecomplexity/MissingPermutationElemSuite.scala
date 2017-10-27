package com.codility.timecomplexity

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MissingPermutationElemSuite extends FunSuite{
  test("Description example") {
    assert(MissingPermutationElem.solution(Array(2,3,1,5)) === 4)
  }
}
