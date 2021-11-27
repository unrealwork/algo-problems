package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

public class InsertInBST {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    } else {
      insertIntoBST(root, null, val);
    }
    return root;
  }

  private void insertIntoBST(TreeNode node, TreeNode parent, int val) {
    if (node == null) {
      if (parent.val < val) {
        parent.right = new TreeNode(val);
      } else {
        parent.left = new TreeNode(val);
      }
    } else {
      insertIntoBST(node.val < val ? node.right : node.left, node, val);
    }
  }
}
