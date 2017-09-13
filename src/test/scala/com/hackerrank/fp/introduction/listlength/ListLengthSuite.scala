package com.hackerrank.fp.introduction.listlength

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListLengthSuite extends FunSuite{
  test("Simple case"){
    assert(ListLength.f(List(1,2,3)) === 3)
  }
}
