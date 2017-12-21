package com.hackerrank.ds.tree;

import java.util.ArrayDeque;

public class TopView {

  void topView(Node root) {
    if (root != null) {
      Node it = root;
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      while (it.left != null) {
        deque.addFirst(it.left.data);
        it = it.left;
      }
      deque.forEach(d -> System.out.printf("%d ", d));
      it = root;
      while (it != null) {
        System.out.printf("%d ", it.data);
        it = it.right;
      }
    }
  }
}
