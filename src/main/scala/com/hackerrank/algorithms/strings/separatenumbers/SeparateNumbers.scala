package com.hackerrank.algorithms.strings.separatenumbers

import scala.io.StdIn

object SeparateNumbers {
  def solve(numbers: Array[String]): Array[Option[Long]] = numbers map isCanSeparate


  def isCanSeparate(sample: String): Option[Long] = {
    if (sample.startsWith("0")) {
      None
    }

    def handleStartNumbers(s: String, f: (String, Long) => Boolean, accString: String): Option[Long] = {
      if (accString.length > sample.length / 2) {
        None
      } else {
        val startNum = accString.toLong
        if (f(sample, startNum)) {
          Some(startNum)
        } else {
          handleStartNumbers(s.tail, f, accString + s.head)
        }
      }
    }

    handleStartNumbers(sample.tail, isCanStartWith, sample.head.toString)
  }

  private def isCanStartWith(sample: String, n: Long): Boolean = {
    def isCanStartWithAcc(sample: String, n: Long, accString: String): Boolean = {
      if (sample == accString) {
        true
      } else {
        if (sample.startsWith(accString)) {
          isCanStartWithAcc(sample, n + 1, accString + n)
        } else {
          false
        }
      }
    }

    isCanStartWithAcc(sample, n, "")
  }

  def main(args: Array[String]) {
    val q = StdIn.readInt()
    val arr: Array[String] = {
      for {
        _ <- 0 until q
      } yield StdIn.readLine
    }.toArray
    solve(arr) foreach (opt => {
      if (opt.isDefined)
        println("YES %d".format(opt.head))
      else
        println("NO")
    })
  }
}
