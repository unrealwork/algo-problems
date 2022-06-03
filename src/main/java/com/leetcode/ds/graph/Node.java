package com.leetcode.ds.graph;


import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> neighbors;

    Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    Node(int v) {
        val = v;
        neighbors = new ArrayList<>();
    }

    Node(int v, List<Node> neighbors) {
        this.val = v;
        this.neighbors = neighbors;
    }
}
