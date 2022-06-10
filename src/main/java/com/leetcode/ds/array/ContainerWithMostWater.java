package com.leetcode.ds.array;

class ContainerWithMostWater {
    private ContainerWithMostWater() {
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int minHeight = Math.min(height[i], height[j]);
        int max = minHeight * (j - i);

        while (j > i) {
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
            minHeight = Math.min(height[i], height[j]);
            max = Math.max(max, minHeight * (j - i));
        }
        return max;
    }
}
