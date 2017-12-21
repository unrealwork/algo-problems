
package com.hackerrank.fp.recursion.strcompression

import scala.annotation.tailrec
import scala.io.StdIn

object StringCompression {

  def solve(str: String): String = {
    @tailrec
    def zipAcc(rest: List[Char], builder: StringBuilder, repeatCount: Int): String = {
      if (rest.isEmpty) {
        if (repeatCount > 1) {
          builder.append(repeatCount).toString()
        } else {
          builder.toString()
        }
      } else {
        if (builder.nonEmpty && builder.last == rest.head) {
          zipAcc(rest.tail, builder, repeatCount + 1)
        } else {
          if (repeatCount > 1) {
            zipAcc(rest.tail, builder.append(repeatCount).append(rest.head), 1)
          } else {
            zipAcc(rest.tail, builder.append(rest.head), 1)
          }
        }
      }
    }

    val list = str.toList
    zipAcc(list.tail, new StringBuilder(list.head.toString), 1)
  }

  def main(args: Array[String]): Unit = {
    print(solve(StdIn.readLine()))
  }
}
