package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

public class SearchInBST {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
  }
}
