package com.leetcode.ds.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
  private ValidParentheses() {}

  public static boolean isValid(String s) {
    final Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(c);
      } else {
        if (isParenthesesPair(stack.peek(), c)) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }
    return stack.isEmpty();
  }

  private static boolean isParenthesesPair(Character left, Character right) {
    return left == '(' && right == ')'
        || left == '[' && right == ']'
        || left == '{' && right == '}';
  }
}
