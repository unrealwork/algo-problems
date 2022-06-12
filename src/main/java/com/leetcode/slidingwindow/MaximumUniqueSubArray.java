package com.leetcode.slidingwindow;

import java.util.Arrays;

class MaximumUniqueSubArray {
    private MaximumUniqueSubArray() {

    }

    public static int maximumUniqueSubarray(int[] nums) {
        int windowStart = 0;
        int windowSum = 0;
        int bestRes = 0;
        int[] lastAppearance = new int[10001];
        Arrays.fill(lastAppearance, -1);
        for (int windowsEnd = 0; windowsEnd < nums.length; windowsEnd++) {
            int cur = nums[windowsEnd];
            if (lastAppearance[cur] > -1) {
                bestRes = Math.max(bestRes, windowSum);
                int newWindowStart = lastAppearance[cur];
                while (windowStart <= newWindowStart) {
                    lastAppearance[nums[windowStart]] = -1;
                    windowSum -= nums[windowStart];
                    windowStart++;
                }
            }
            windowSum += cur;
            lastAppearance[cur] = windowsEnd;
        }
        bestRes = Math.max(bestRes, windowSum);
        return bestRes;
    }
}
