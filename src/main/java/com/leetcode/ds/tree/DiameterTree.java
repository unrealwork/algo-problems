package com.leetcode.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

class DiameterTree {
    private DiameterTree() {
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger diameter = new AtomicInteger(0);
        maxDepthRecursive(root, 0, diameter);
        return diameter.get();
    }

    private static int maxDepthRecursive(TreeNode curNode, int height, AtomicInteger maxDiameter) {
        if (curNode == null) {
            return height;
        } else {
            height++;
            int leftHeight = maxDepthRecursive(curNode.left, height, maxDiameter);
            int rightHeight = maxDepthRecursive(curNode.right, height, maxDiameter);
            int curDiameter = leftHeight + rightHeight + 2;
            if (curDiameter > maxDiameter.get()) {
                maxDiameter.set(curDiameter);
            }
            return Math.max(leftHeight,
                    rightHeight);
        }
    }

}
