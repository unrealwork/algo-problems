package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

public class TwoSumBST {
  public boolean findTarget(TreeNode root, int k) {
    int[] dict = preorderTraversal(root);
    for (int i = 0; i < dict.length; i++) {
      if (dict[i] > 0) {
        if (dict[k - i])
      }
    }
  }

  public int[] preorderTraversal(TreeNode root) {
    int[] dict = new int[10000];
    traverse(root, dict);
    return dict;
  }

  private void traverse(final TreeNode node, int[] dict) {
    if (node != null) {
      traverse(node.left, dict);
      dict[node.val]++;
      traverse(node.right, dict);
    }
  }
}
