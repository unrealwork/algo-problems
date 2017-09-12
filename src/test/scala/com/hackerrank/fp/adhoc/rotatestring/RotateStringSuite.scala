package com.hackerrank.fp.adhoc.rotatestring

import org.scalatest.FunSuite

class RotateStringSuite extends FunSuite {
  test("abc rotations") {
    assert(RotateString.rotation("abc") == List("bca", "cab", "abc"))
  }

  test("aaa rotations") {
    assert(RotateString.rotation("aaa") == List("aaa", "aaa", "aaa"))
  }
}
