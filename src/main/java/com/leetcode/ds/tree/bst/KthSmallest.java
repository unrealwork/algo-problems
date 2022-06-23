package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class KthSmallest {
    private KthSmallest() {

    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int i = 0;
        TreeNode node = root;
        while (i < k || !stack.isEmpty()) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }
            node = stack.removeLast();
            i++;
            if (i == k) {
                break;
            }
            node = node.right;
        }
        return node.val;
    }
}
