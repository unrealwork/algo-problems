package com.hackerrank.algorithms.implementation.twosets

object BetweenTwoSets {

  private def gcd(a: Long, b: Long): Long = {
    if (a == b) {
      a
    } else {
      if (a > b) {
        gcd(a - b, b)
      } else {
        gcd(a, b - a)
      }
    }
  }

  private def lcm(a: Long, b: Long): Long = {
    a * (b / gcd(a, b))
  }

  private def gcd(a: Array[Long]): Long = {
    if (a.isEmpty) {
      throw new IllegalArgumentException
    } else {
      if (a.length == 1) {
        a(0)
      } else {
        a.tail.foldLeft(a.head)(gcd)
      }
    }
  }

  private def lcm(a: Array[Long]): Long = {
    if (a.isEmpty) {
      throw new IllegalArgumentException
    } else {
      if (a.length == 1) {
        a(0)
      } else {
        a.tail.foldLeft(a.head)(lcm)
      }
    }
  }

  def getTotalX(a: Array[Long], b: Array[Long]): Long = {
    def count(cur: Long, low: Long, up: Long, res: Long): Long = {
      if (cur <= up || up % cur == 0) {
        if (up % cur == 0) {
          count(cur + low, low, up, res + 1)
        } else {
          count(cur + low, low, up, res)
        }
      } else {
        res
      }
    }

    val low = lcm(a)
    count(low, low, gcd(b), 0)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var a = new Array[Long](n);
    for (a_i <- 0 to n - 1) {
      a(a_i) = sc.nextInt();
    }
    var b = new Array[Long](m);
    for (b_i <- 0 to m - 1) {
      b(b_i) = sc.nextInt();
    }
    val total = getTotalX(a, b);
    println(total)
  }
}
