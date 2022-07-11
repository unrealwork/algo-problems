package com.leetcode.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RightSide {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        while (!deque.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            nextLevel.clear();
            Iterator<TreeNode> it = deque.iterator();
            while (it.hasNext()) {
                TreeNode tn = it.next();
                level.add(tn.val);
                if (tn.left != null) {
                    nextLevel.add(tn.left);
                }
                if (tn.right != null) {
                    nextLevel.add(tn.right);
                }
                it.remove();
            }
            if (!level.isEmpty()) {
                res.add(level.peekLast());
            }
            deque.addAll(nextLevel);
        }
        return res;
    }
}
