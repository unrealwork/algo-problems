package com.hackerrank.fp.recursion.gcd

object GCD {

  def gcd(x: Int, y: Int): Int = {
    if (x == y) {
      x
    } else {
      if (x > y) {
        gcd(x - y, y)
      } else {
        gcd(x, y - x)
      }
    }

  }


  /** This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair: List[Int]) = {
    println(gcd(pair.head, pair.reverse.head))
  }

  def main(args: Array[String]) {
    /** The part relates to the input/output. Do not change or modify it **/
    acceptInputAndComputeGCD(readLine().trim().split(" ").map(x => x.toInt).toList)

  }
}
