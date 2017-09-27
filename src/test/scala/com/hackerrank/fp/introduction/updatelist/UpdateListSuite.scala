package com.hackerrank.fp.introduction.updatelist

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class UpdateListSuite extends FunSuite {
  test("Simple case") {
    assert(UpdateList.f(List(1, -2)) == List(1, 2))
  }
}
