package com.leetcode.ds.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NaryPreorderTraversal {
    private NaryPreorderTraversal() {
        
    }

    public static List<Integer> preorder(Node root) {
        final List<Integer> res = new LinkedList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        preorder(root, res);
        return res;
    }

    private static void preorder(Node cur, List<Integer> acc) {
        acc.add(cur.val);
        for (Node child : cur.children) {
            preorder(child, acc);
        }
    }
}
