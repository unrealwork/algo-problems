package com.leetcode.ds.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class SortAnArray {
    private SortAnArray() {
        
    }

    private static final int CHUNK_SIZE = 256;
    public static final int CHUNK_AMOUNT = 4;

    public static int[] sortArray(int[] nums) {
        int mask = 0xff;
        List<List<Integer>> bucket = new ArrayList<>(CHUNK_SIZE);
        for (int i = 0; i < CHUNK_SIZE; i++) {
            bucket.add(new LinkedList<>());
        }
        int shift = 0;
        for (int j = 0; j < CHUNK_AMOUNT; j++) {
            for (int num : nums) {
                int bucketNum = (num & mask) >> shift;
                if (bucketNum < 0) {
                    bucketNum = bucketNum & (0x7f);
                }
                bucket.get(bucketNum).add(num);
            }
            refill(nums, bucket);
            shift += 8;
            mask = (mask << 8);
        }
        int[] res = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            if (num < 0) {
                res[k] = num;
                k++;
            }
        }
        for (int num : nums) {
            if (num >= 0) {
                res[k] = num;
                k++;
            }
        }
        return res;
    }

    private static void refill(int[] nums, List<List<Integer>> buckets) {
        int i = 0;
        for (List<Integer> b : buckets) {
            for (Integer n : b) {
                nums[i] = n;
                i++;
            }
            b.clear();
        }
    }
}
