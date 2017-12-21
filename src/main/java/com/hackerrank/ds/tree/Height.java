package com.hackerrank.ds.tree;

import java.util.Scanner;

public class Height {

  static int height(Node root) {
    return height(root, 0) - 1;
  }

  static int height(Node root, int res) {
    if (root == null) {
      return res;
    } else {
      return Math.max(height(root.left, res + 1),
          height(root.right, res + 1));
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    int height = height(root);
    System.out.println(height);
  }
}
