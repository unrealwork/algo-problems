package com.leetcode.ds.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SymetricTree {
  private SymetricTree() {}

  private static boolean isPalindrome(List<Integer> list) {
    final int halfSize = list.size() / 2;
    for (int i = 0; i < halfSize; i++) {
      if (!Objects.equals(list.get(i), list.get(list.size() - i - 1))) {
        return false;
      }
    }
    return true;
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    LinkedList<TreeNode> deque = new LinkedList<>();
    deque.add(root);
    LinkedList<TreeNode> nextLevel = new LinkedList<>();
    while (!deque.isEmpty()) {
      List<Integer> level = new ArrayList<>(deque.size());
      nextLevel.clear();
      Iterator<TreeNode> it = deque.iterator();
      boolean containsOnlyNull = true;
      while (it.hasNext()) {
        Iterator<TreeNode> prev = it;
        TreeNode tn = it.next();
        level.add(tn == null ? null : tn.val);
        if (tn != null) {
          if (containsOnlyNull && (tn.right != null || tn.left != null)) {
            containsOnlyNull = false;
          }
          nextLevel.add(tn.left);
          nextLevel.add(tn.right);
        } else {
          nextLevel.add(null);
          nextLevel.add(null);
        }

        prev.remove();
      }
      if (!isPalindrome(level)) {
        return false;
      }
      if (containsOnlyNull) {
        break;
      }
      deque.addAll(nextLevel);
    }
    return true;
  }
}
