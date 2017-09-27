package com.hackerrank.fp.recursion.gcd

import org.scalatest.FunSuite

class GCDSuite  extends FunSuite{

  test("Simple case") {
    assert(GCD.gcd(27, 18) == 9)
  }
}
