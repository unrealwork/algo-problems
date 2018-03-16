
package com.leetcode

class MinStack {
  private var tail: Option[Node[Int]] = Option.empty
  private var min: Option[Int] = Option.empty

  /** initialize your data structure here. */
  private class Node[T](_value: T, _next: Option[Node[T]],
                        _previous: Option[Node[T]], _min: T) {
    def append(x: T, min: T): Node[T] = {
      new Node(value, Some(new Node[T](x, None, Some(this), min)))
    }

    // Store link to node in minimal list
    def this(x: T) {
      this(x, None, None, x)
    }

    def this(x: T, min: T) {
      this(x, None, None, min)
    }

    def this(x: T, next: Option[Node[T]]) {
      this(x, next, None, x)
    }

    def value: T = _value

    def previous: Option[Node[T]] = _previous

    def next: Option[Node[T]] = _next

    def min: T = _min
  }


  def push(x: Int) {
    if (tail.isEmpty) {
      tail = Some(new Node(x))
    } else {
      val tailValue = tail.get
      val min = if (tailValue.min > x) x else tailValue.min
      tail = Some(new Node(x, None, tail, min))
    }
  }

  def pop() {
    if (tail.nonEmpty) {
      if (tail.get.previous.nonEmpty) {
        val previousNode = tail.get.previous.get
        tail = Some(new Node(previousNode.value, None, previousNode.previous, previousNode.min))
      } else {
        tail = None
      }
    }
  }

  def top(): Int = {
    if (tail.nonEmpty) {
      tail.get.value
    } else {
      throw new IllegalStateException
    }
  }

  def getMin(): Int = {
    if (tail.nonEmpty) {
      tail.get.min
    } else {
      -1
    }
  }
}
