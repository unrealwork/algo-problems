
package com.hackerrank.fp.recursion

import scala.io.StdIn
import scala.util.Properties

object Crossword {
  final val size = 10
  type Crossword = Array[Array[Char]]

  def cloneCrossword(crossword: Crossword): Crossword = {
    val result = Array.ofDim[Array[Char]](crossword.length)
    for (x <- 0 until crossword.length) {
      result(x) = Array.ofDim[Char](crossword(x).length)
      for (y <- 0 until crossword(x).length) {
        result(x)(y) = crossword(x)(y)
      }
    }
    result
  }

  def solve(crossword: Crossword, words: Set[String]): Crossword = {
    var solution: Option[Crossword] = Option.empty

    def crosswordPuzzleRec(crossword: Array[Array[Char]], restWords: Set[String], wordOptional: Option[String], isHorizontal: Boolean, curI: Int, curJ: Int): Unit = {
      if (solution.isEmpty && wordOptional.isEmpty && restWords.isEmpty) {
        solution = Option(crossword)
      }
      else if (wordOptional.isDefined) {
        val currentWord = wordOptional.get
        val length = currentWord.length
        if (isHorizontal) {
          var j = curJ
          val lastIndex = length + curJ
          if (lastIndex > 10) return
          while ( {
            j < 10 && j < lastIndex
          }) {
            val symbol = crossword(curI)(j)
            val wordIndex = j - curJ
            if (symbol == '-') { //empty - fill with letter
              crossword(curI)(j) = currentWord.charAt(wordIndex)
            }
            else { // edge
              if (symbol == '+') return
              else { // letter
                if (symbol != currentWord.charAt(wordIndex)) return
              }
            }
            j += 1
          }
          // Finish word
          if (j >= 10 || crossword(curI)(j) == '+') { //correct word - try to fit next word
            crosswordPuzzleRec(crossword, restWords, Option.empty, false, 0, 0)
          }
        }
        else {
          var i = curI
          val lastIndex = length + curI
          if (lastIndex > 10) return
          while ( {
            i < 10 && i < lastIndex
          }) {
            val symbol = crossword(i)(curJ)
            val wordIndex = i - curI
            if (symbol == '-') {
              crossword(i)(curJ) = currentWord.charAt(wordIndex)
            }
            else {
              if (symbol == '+') {
                return
              } else {
                if (symbol != currentWord.charAt(wordIndex)) {
                  return
                }
              }
            }
            i += 1
          }
          if (i >= 10 || crossword(i)(curJ) == '+') {
            crosswordPuzzleRec(crossword, restWords, Option.empty, false, 0, 0)
          }
        }
      }
      else {
        for (i <- Stream.range(curI, 10)) {
          for (j <- Stream.range(curI, 10)) {
            val symbol = crossword(i)(j)
            if (symbol != '+') {
              if (j + 1 < 10 && crossword(i)(j + 1) == '-' && ((j == 0) || crossword(i)(j - 1) == '+')) {
                for (nextWord <- restWords) {
                  val copy = cloneCrossword(crossword)
                  crosswordPuzzleRec(copy, restWords - nextWord, Option(nextWord), true, i, j)
                }
              }
              if (i + 1 < 10 && crossword(i + 1)(j) == '-' && ((i == 0) || crossword(i - 1)(j) == '+')) {
                for (nextWord <- restWords) {
                  crosswordPuzzleRec(cloneCrossword(crossword), restWords - nextWord, Option(nextWord), false, i, j)
                }
              }
            }
          }
        }
      }
    }

    crosswordPuzzleRec(crossword, words, Option.empty, false, 0, 0)
    solution.get
  }

  def main(args: Array[String]): Unit = {
    val crossword: Crossword = Stream.range(0, size).map(_ => StdIn.readLine().toCharArray).toArray
    val words = StdIn.readLine().split(";").toSet
    val solution = solve(crossword, words)
    print(solution.map(arr => new String(arr)).mkString(Properties.lineSeparator))
  }

}
