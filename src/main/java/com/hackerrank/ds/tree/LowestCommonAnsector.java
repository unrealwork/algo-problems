package com.hackerrank.ds.tree;

public class LowestCommonAnsector {

  static Node lca(Node root,int v1,int v2)
  {
    Node temp = root; // not necessary, just use root, just a leftover from a different attempt.

    while (true) {
      if (temp.data > v1 && temp.data > v2) {
        temp = temp.left;
      } else if (temp.data < v1 && temp.data < v2) {
        temp = temp.right;
      } else {
        return temp;
      }
    }
  }
}
