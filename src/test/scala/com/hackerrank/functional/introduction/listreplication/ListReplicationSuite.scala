package com.hackerrank.functional.introduction.listreplication

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListReplicationSuite extends FunSuite {
  test("Simple Test") {
    assert(ListReplication.f(2, List(1, 2, 3)) === List(1, 1, 2, 2, 3, 3))
  }
}
