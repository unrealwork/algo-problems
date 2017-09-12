package com.hackerrank.algorithms.strings.caesarcipher

object CaesarCipher {
  def solution(string: String, shift: Int): String = {
    val AlphabetSize = 26

    def shiftLetter(c: Char, startSymbol: Char): Char = {
      ((c - startSymbol + shift) % AlphabetSize + startSymbol).toChar
    }

    def shiftChar(c: Char): Char = {
      if (c.isLetter) {
        if (c.isUpper) {
          shiftLetter(c, 'A')
        } else {
          shiftLetter(c, 'a')
        }
      } else {
        c
      }
    }

    string map (shiftChar)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val n = sc.nextInt()
    val s = sc.next()
    val k = sc.nextInt()
    println(solution(s, k))
  }
}
