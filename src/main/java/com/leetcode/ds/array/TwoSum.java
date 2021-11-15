package com.leetcode.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private TwoSum() {
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer diffIndex = map.get(diff);
            if (diffIndex != null && diffIndex != i) {
                return new int[]{i, diffIndex};
            }
        }
        return new int[]{};
    }
}
