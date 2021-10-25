package com.leetcode.daily;

public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    throw new IllegalStateException();
  }

  private TreeInfo solve(TreeInfo info) {
    if (TreeInfo.isFinal(info)) {
      return info;
    } else {
      if (info.node.left != null && info.node.left.left == null) {
        return null;
      }
      final TreeInfo leftInfo = solve(TreeInfo.left(info));
      if(leftInfo != null) {
        return leftInfo;
      }
      return null;
    }
  }

  static class TreeInfo {
    final TreeNode node;
    final int depth;
    final int shift;

    TreeInfo(TreeNode node, int depth, int shift) {
      this.node = node;
      this.depth = depth;
      this.shift = shift;
    }

    static TreeInfo base(TreeNode node) {
      return new TreeInfo(node, 0, 0);
    }

    static TreeInfo left(TreeInfo treeInfo) {
      return new TreeInfo(treeInfo.node, treeInfo.depth + 1, treeInfo.shift - 1);
    }

    static TreeInfo right(TreeInfo treeInfo) {
      return new TreeInfo(treeInfo.node, treeInfo.depth + 1, treeInfo.shift + 1);
    }

    static boolean isFinal(TreeInfo treeInfo) {
      return treeInfo.node.right == null;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
