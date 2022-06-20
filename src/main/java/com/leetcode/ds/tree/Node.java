package com.leetcode.ds.tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    final List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int val) {
        this();
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
