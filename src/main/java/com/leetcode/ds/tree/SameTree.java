package com.leetcode.ds.tree;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <br>
 * <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 *
 * @author unrealwork
 */
final class SameTree {
    private SameTree(){
        
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}    
