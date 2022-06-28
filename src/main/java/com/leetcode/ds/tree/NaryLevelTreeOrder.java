package com.leetcode.ds.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class NaryLevelTreeOrder {
    private NaryLevelTreeOrder() {

    }   

    public static List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> levels = new LinkedList<>();
        final Deque<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                Node next = queue.removeLast();
                level.add(next.val);
                for (Node child : next.children) {
                    queue.addFirst(child);
                }
            }

            if (!level.isEmpty()) {
                levels.add(level);
            }
        }
        return levels;
    }
}
