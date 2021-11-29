package com.leetcode.ds.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
  private Deque<Integer> stack = new LinkedList<>();

  public MyQueue() {}

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(x);
    } else {
      int last = stack.pop();
      Deque<Integer> res = new LinkedList<>();
      res.push(x);
      while (!stack.isEmpty()) {
        res.push(stack.pop());
      }
      stack = res;
    }
  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.peek();
  }

  public boolean empty() {
    return stack.isEmpty();
  }
}
