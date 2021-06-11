package com.hackerrank.days30.bst;

import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class LevelOrder {

    static void levelOrder(Node root) {
        //Write your code here
        final Queue<Node> lastLevel = new LinkedList<>();
        if (root != null) {
            lastLevel.add(root);
        }
        while (!lastLevel.isEmpty()) {
            final LinkedList<Node> next = new LinkedList<>();
            while (!lastLevel.isEmpty()) {
                final Node parent = lastLevel.remove();
                System.out.printf("%d ",parent.data);
                if (parent.left != null) {
                    next.add(parent.left);
                }
                if (parent.right != null) {
                    next.add(parent.right);
                }
            }
            lastLevel.addAll(next);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}

