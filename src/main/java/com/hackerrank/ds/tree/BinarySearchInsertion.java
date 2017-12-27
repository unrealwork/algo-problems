package com.hackerrank.ds.tree;

public class BinarySearchInsertion {

  static Node Insert(Node root, int value) {
    if (root != null) {
      Insert(root, null, value);
      return root;
    } else {
      Node result = new Node();
      result.data = value;
      return result;
    }
  }

  static void Insert(Node root, Node ancestor, int value) {
    if (root == null) {
      if (ancestor.data > value) {
        ancestor.left = new Node();
        ancestor.left.data = value;
      } else {
        ancestor.right = new Node();
        ancestor.right.data = value;
      }
    } else {
      if (root.data < value) {
        Insert(root.right, root, value);
      } else {
        Insert(root.left, root, value);
      }
    }
  }

  public static void main(String[] args) {
    Node n = new Node(4);
    n = Insert(n, 2);
    System.out.println("a");
  }
}
