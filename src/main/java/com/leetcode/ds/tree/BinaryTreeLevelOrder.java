package com.leetcode.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {
  private BinaryTreeLevelOrder() {}

  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    LinkedList<TreeNode> deque = new LinkedList<>();
    deque.add(root);
    LinkedList<TreeNode> nextLevel = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    while (!deque.isEmpty()) {
      List<Integer> level = new ArrayList<>(deque.size());
      nextLevel.clear();
      Iterator<TreeNode> it = deque.iterator();
      while (it.hasNext()) {
        Iterator<TreeNode> prev = it;
        TreeNode tn = it.next();
        level.add(tn.val);
        if (tn.left != null) {
          nextLevel.add(tn.left);
        }
        if (tn.right != null) {
          nextLevel.add(tn.right);
        }
        prev.remove();
      }
      res.add(level);
      deque.addAll(nextLevel);
    }
    return res;
  }
}
