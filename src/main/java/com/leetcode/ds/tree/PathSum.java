package com.leetcode.ds.tree;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return hasPathSum(root, 0, targetSum);
  }

  private boolean hasPathSum(TreeNode node, int sum, int targetSum) {
    if (node == null) {
      return false;
    }
    if (node.left == null && node.right == null) {
      return sum + node.val == targetSum;
    } else {
      final int nextSum = sum + node.val;
      return hasPathSum(node.left, nextSum, targetSum)
          || hasPathSum(node.right, nextSum, targetSum);
    }
  }
}
