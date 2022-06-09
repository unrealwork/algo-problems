package com.leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        return bellPermutation(nums);
    }



    private static List<List<Integer>> bellPermutation(int[] nums) {
        int[] c = new int[nums.length];
        int i = 1;
        List<List<Integer>> res = new LinkedList<>();
        res.add(asList(nums));
        while (i < nums.length) {
            if (c[i] < i) {
                int swapIndex = (i & 1) * c[i];
                swapArr(nums, swapIndex, i);
                res.add(asList(nums));
                c[i]++;
                i = 1;
            } else {
                c[i] = 0;
                i++;
            }
        }
        return res;
    }

    private static void bellPermutationsRec(List<List<Integer>> generated, int[] currentPerm, int arraySize) {
        if (arraySize == 1) {
            if (generated != null) {
                generated.add(asList(currentPerm));
            }
        } else {
            int nextArraySize = arraySize - 1;
            bellPermutationsRec(generated, currentPerm, nextArraySize);
            boolean isEven = arraySize % 2 == 0;
            for (int i = 0; i < nextArraySize; i++) {
                if (isEven) {
                    swapArr(currentPerm, i, nextArraySize);
                } else {
                    swapArr(currentPerm, 0, nextArraySize);
                }
                bellPermutationsRec(generated, currentPerm, nextArraySize);
            }
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static List<Integer> asList(int[] arr) {
        List<Integer> res = new ArrayList<>(arr.length);
        for (int n : arr) {
            res.add(n);
        }
        return res;
    }
}
