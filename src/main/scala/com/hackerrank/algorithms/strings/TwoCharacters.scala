package com.hackerrank.algorithms.strings

import scala.annotation.tailrec

object TwoCharacters {

  def isValid(string: String): Boolean = {
    @tailrec
    def isValidTail(previous: Char, rest: String): Boolean = {
      if (rest.isEmpty) {
        true
      } else {
        val currentChar = rest.head
        if (previous == currentChar) {
          false
        } else {
          isValidTail(currentChar, rest.tail)
        }
      }
    }

    !string.isEmpty && isValidTail(string.head, string.tail)
  }

  // TODO: Combinations of all char sequences from set of chars with specified length
  def combinations(chars: Set[Char], size: Int): Set[List[Char]] = null

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var len = sc.nextInt()
    var s = sc.next()
  }
}
