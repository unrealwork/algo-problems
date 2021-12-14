package com.leetcode.ds.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
  private final Deque<Integer> mainStack;
  private final Deque<Integer> minOrderStack;

  public MinStack() {
    mainStack = new LinkedList<>();
    minOrderStack = new LinkedList<>();
  }

  public void push(int val) {
    mainStack.push(val);
    if (minOrderStack.isEmpty() || minOrderStack.peek() > val) {
      minOrderStack.push(val);
    } else {
      minOrderStack.push(minOrderStack.peek());
    }
  }

  public void pop() {
    if (!mainStack.isEmpty()) {
      mainStack.pop();
      minOrderStack.pop();
    }
  }

  public int top() {
    return mainStack.peek();
  }

  public int getMin() {
    return minOrderStack.peek();
  }
}
