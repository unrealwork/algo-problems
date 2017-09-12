package com.hackerrank.algorithms.strings.caesarcipher

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CaesarCipherSuite extends FunSuite {
  test("Description example") {
    assert(CaesarCipher.solution("middle-Outz", 2) === "okffng-Qwvb")
  }
}
