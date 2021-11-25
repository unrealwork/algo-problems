package com.leetcode.ds.tree;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    traverse(root, list);
    return list;
  }

  private void traverse(final TreeNode node, List<Integer> list) {
    if (node != null) {
      traverse(node.left, list);
      list.add(node.val);
      traverse(node.right, list);
    }
  }
}
