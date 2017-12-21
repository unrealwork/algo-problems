package com.hackerrank.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Traversal {

  void preOrder(Node root) {
    if (root != null) {
      System.out.printf("%d ", root.data);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  void postOrder(Node root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.printf("%d ", root.data);
    }
  }

  void inOrder(Node root) {
    if (root != null) {
      inOrder(root.left);
      System.out.printf("%d ", root.data);
      inOrder(root.right);
    }
  }

  void levelOrder(Node root) {
    if (root != null) {
      Queue<Node> order = new ArrayDeque<>();
      order.add(root);
      levelOrder(order);
    }
  }

  void levelOrder(Queue<Node> level) {
    if (level.size() > 0) {
      Queue<Node> newLevel = new ArrayDeque<>();
      for (Node n : level) {
        System.out.printf("%d ", n.data);
        if (n.left != null) {
          newLevel.add(n.left);
        }
        if (n.right != null) {
          newLevel.add(n.right);
        }
      }
      levelOrder(newLevel);
    }
  }
}
