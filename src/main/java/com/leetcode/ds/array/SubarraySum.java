package com.leetcode.ds.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class SubarraySum {
    private SubarraySum() {

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> prefixSum = prefixMap(nums);
        for (Map.Entry<Integer, List<Integer>> kv : prefixSum.entrySet()) {
            int curSum = kv.getKey();
            List<Integer> lastIndexes = kv.getValue();
            if (k == 0) {
                int size = lastIndexes.size();
                if (size > 1) {
                    count += (size - 1) * size / 2;
                }
            } else {
                int target = curSum - k;
                count = updateCount(count, prefixSum, lastIndexes, target);
            }
        }
        return count;
    }

    private static int updateCount(int count, Map<Integer, List<Integer>> prefixSum, List<Integer> lastIndexes, int target) {
        List<Integer> targetIndexes = prefixSum.get(target);
        if (targetIndexes != null) {
            for (Integer lastIndex : lastIndexes) {
                for (Integer targetIndex : targetIndexes) {
                    if (targetIndex < lastIndex) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    private static Map<Integer, List<Integer>> prefixMap(int[] nums) {
        Map<Integer, List<Integer>> prefixSum = new HashMap<>(nums.length);
        prefixSum.put(0, new LinkedList<>(Collections.singleton(0)));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum.computeIfAbsent(sum, s -> new ArrayList<>())
                    .add(i + 1);
        }
        return prefixSum;
    }
}
