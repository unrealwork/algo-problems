package com.hackerrank.algorithms.strings.twocharacters

import scala.annotation.tailrec

object TwoCharacters {
  def solution(s: String): Int = {
    val charSet = s.toSet
    val pairs = combinations(charSet, 2)
    val validCases = pairs.map(pair => s.filter(c => pair.contains(c)))
      .filter(isValid)
      .map(s => s.length)
    if (validCases.isEmpty) 0 else validCases.max
  }

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

  def combinations[Char](chars: Set[Char], size: Int): Set[Set[Char]] = {
    def iterate(chars: Set[Char], f: (Char, Set[Char]) => Set[Set[Char]]): Set[Set[Char]] = {
      def iterateAcc(chars: Set[Char], f: (Char, Set[Char]) => Set[Set[Char]], res: Set[Set[Char]], currentChar: Char): Set[Set[Char]] = {
        if (chars.isEmpty) {
          f(currentChar, chars) ++ res
        } else {
          res ++ iterateAcc(chars.tail, f, f(currentChar, chars) ++ res, chars.head)
        }
      }

      if (chars.isEmpty) {
        Set()
      } else {
        iterateAcc(chars.tail, f, Set(), chars.head)
      }
    }


    def accCombinations(currentChar: Char, currentSeq: List[Char], chars: Set[Char]): Set[Set[Char]] = {
      val newSeq = currentChar :: currentSeq
      if (1 + currentSeq.length == size) {
        Set(newSeq.toSet)
      } else {
        if (chars.isEmpty && (1 + currentSeq.length < size)) {
          Set()
        }
        iterate(chars, (c, restChars) =>
          accCombinations(c, newSeq, restChars))
      }
    }

    iterate(chars, (c, restPart) => accCombinations(c, List.empty, restPart))
  }


  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var len = sc.nextInt()
    val s = sc.next()
    println(solution(s))
  }
}
