package com.leetcode.ds.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int li, int hi) {
        if (hi <= li) {
            return null;
        } else {
            int mi = (hi - li) / 2 + li;
            return new TreeNode(nums[mi], sortedArrayToBST(nums, li, mi), sortedArrayToBST(nums, mi + 1, hi));
        }
    }
}
