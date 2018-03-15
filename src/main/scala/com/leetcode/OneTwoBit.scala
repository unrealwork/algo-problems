
package com.leetcode

object OneTwoBit {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    solve(bits.tail, bits.head, isFinished = true)
  }

  private def solve(rest: Array[Int], cur: Int, isFinished: Boolean): Boolean = {
    if (rest.isEmpty) {
      isFinished && cur == 0
    } else {
      solve(rest.tail, rest.head, !isFinished || cur == 0)
    }
  }
}
