package com.leetcode.ds.tree.bst;

import com.leetcode.ds.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class BSTIterator {
    private TreeNode node;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.node = root;
        this.stack = new LinkedList<>();
    }

    public int next() {
        while (node != null) {
            stack.addLast(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }

    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }
}
