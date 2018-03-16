
package com.leetcode

import org.scalatest.PropSpec

class MinStackSuite extends PropSpec {
  val stack = new MinStack

  property("After Push top element should be equals to added") {
    stack.push(2)
    assert(stack.top() == 2)
    assert(stack.getMin() == 2)
  }


  property("After second push top value should be changed") {
    stack.push(1)
    assert(stack.top() == 1)
    assert(stack.getMin() == 1)
  }

  property("After remove last value should be available to push new items") {
    stack.pop()
    stack.push(3)
    assert(stack.top() == 3)
  }

  property("Correct min value after several pushes and pops") {
    stack.pop()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    assert(stack.getMin() === -3)
    stack.pop()
    assert(stack.top() === 0)
    assert(stack.getMin() === -2)
  }
}
