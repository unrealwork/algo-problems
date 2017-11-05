package com.hackerrank.algorithms.implementation.twosets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BetweenTwoSetsSuite extends FunSuite{
//  test("Description example") {
//    assert(BetweenTwoSets.getTotalX(Array(2, 4), Array(16, 48, 96)) === 3)
//  }
//
//  test("Input 3") {
//    assert(BetweenTwoSets.getTotalX(Array(2), Array(20, 30, 12)) === 1)
//  }



  test("Input 2") {
    assert(BetweenTwoSets.getTotalX(Array(100, 99, 98, 97, 96, 95, 94, 93, 92, 91), Array(1, 2 ,3 )) === 0)
  }
}
