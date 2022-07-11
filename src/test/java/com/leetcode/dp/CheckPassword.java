package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPassword {
    public static boolean check(char[] password) {
        if (password.length < 8) {
            return false;
        }
        int digitCount = 0;
        for (char c : password) {
            boolean isDigit = Character.isDigit(c);
            if (!isDigit && !Character.isAlphabetic(c)) {
                return false;
            }
            if (isDigit) {
                digitCount++;
            }
        }
        return digitCount > 1;
    }

    public static int[] rotate(int[] arr) {
        rotate(arr,2);
        
        /* You do not need to worry about the return statement for the 
        moment and just set the values in “arr” correctly*/
        return arr;
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static ArrayList<Integer> separate(ArrayList<Integer> myList) {

        // Enter your code here
        List<Integer> odd = myList.stream()
                .filter(i -> i % 2  != 0)
                .collect(Collectors.toList());


        List<Integer> even = myList.stream()
                .filter(i -> i % 2  != 0)
                .collect(Collectors.toList());
        
        /* You do not need to worry about the return statement for the 
        moment and just set the values in “myList” correctly*/
        return myList;
    }
}
