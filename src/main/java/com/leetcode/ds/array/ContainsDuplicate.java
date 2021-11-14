package com.leetcode.ds.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private ContainsDuplicate() {
        
    }

    public static boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
