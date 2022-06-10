package com.leetcode.ds.array;

class SortColors {
    private SortColors() {
    }

    public static void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        int k = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[k] = i;
                k++;
            }
        }
    }
}
