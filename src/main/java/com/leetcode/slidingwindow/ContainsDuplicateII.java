package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class ContainsDuplicateII {
    private ContainsDuplicateII() {

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        if (k == 0) {
            return false;
        }
        final Map<Integer, Integer> windowDict = new HashMap<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (windowDict.containsKey(nums[i])) {
                return true;
            }
            if (windowDict.size() == k) {
                windowDict.remove(nums[i - k]);
            }
            windowDict.put(nums[i], i);
        }
        return false;
    }
}
