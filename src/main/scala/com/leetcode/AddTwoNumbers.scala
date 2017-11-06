package com.leetcode

object AddTwoNumbers {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def iter(first: ListNode, second: ListNode, tmp: Int, result: ListNode): ListNode = {
      if (first == null && second == null) {
        if (tmp > 0) {
          pop(tmp, result)
        } else {
          result
        }
      } else {
        if (first == null) {
          val sum = tmp + second.x
          iter(null, second.next, sum / 10, pop(sum % 10, result))
        } else if (second == null) {
          val sum = tmp + first.x
          iter(first.next, null, sum / 10, pop(sum % 10, result))
        } else {
          val sum = tmp + first.x + second.x
          iter(first.next, second.next, sum / 10, pop(sum % 10, result))
        }
      }
    }

    reverse(iter(l1, l2, 0, null))
  }

  def pop(x: Int, listNode: ListNode): ListNode = {
    val newNode = new ListNode(x)
    newNode.next = listNode
    newNode
  }

  def reverse(list: ListNode): ListNode = {
    def iter(curNode: ListNode, result: ListNode): ListNode = {
      if (curNode == null) {
        result
      } else {
        val newResult = new ListNode(curNode.x)
        newResult.next = result
        iter(curNode.next, newResult)
      }
    }

    iter(list, null)
  }

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

}
