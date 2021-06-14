package com.hackerrank.java.ds;


import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Subarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int size = scanner.nextInt();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }
            int arraysCount = size;
            int answerCount = 0;
            final int[] subSizes = Arrays.copyOf(nums, size);
            while (arraysCount > 0) {
                final int diff = size - arraysCount;
                for (int i = 0; i < arraysCount; i++) {
                    if (subSizes[i] < 0) {
                        answerCount++;
                    }
                    if (i > 0) {
                        subSizes[i - 1] += nums[i + diff];
                    }
                }
                arraysCount--;
            }
            System.out.println(answerCount);
        }
    }
}
