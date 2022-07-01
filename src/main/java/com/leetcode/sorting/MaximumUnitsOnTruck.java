package com.leetcode.sorting;

import java.util.Arrays;

class MaximumUnitsOnTruck {
    private MaximumUnitsOnTruck() {

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (bt1, bt2) -> bt2[1] - bt1[1]);
        int unitsSum = 0;
        int curSize = 0;
        int boxIndex = 0;
        while (boxIndex < boxTypes.length && curSize < truckSize) {
            int[] bt = boxTypes[boxIndex];
            int boxCount = bt[0];
            int unitsPerBox = bt[1];
            int takenCount = Math.min(truckSize - curSize, boxCount);
            unitsSum += unitsPerBox * takenCount;
            curSize += takenCount;
            boxIndex++;
        }
        return unitsSum;
    }
}
