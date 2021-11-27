package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p) {
      return p;
    }
    if (root == q) {
      return q;
    }
    if (root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.val < q.val ? root.right : root.left, p, q);
    } else {
      return root;
    }
  }
}
