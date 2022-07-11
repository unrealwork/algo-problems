package com.leetcode.dp;

public class UglyNumber {
    public static boolean ugly(int number) {
        // Enter your code here
        int rest = number;
        while (rest > 1) {
            if (rest % 2 == 0 || rest % 3 == 0 || rest % 5 == 0) {
                if (rest % 2 == 0) {
                    rest /= 2;
                }
                if (rest % 3 == 0) {
                    rest /= 3;
                }
                if (rest % 5 == 0) {
                    rest /= 5;
                }
            } else {
                break;
            }
        }
        /* You do not need to worry about the return statement for the 
        moment, write your code and replace it with your return statement.*/
        return rest == 1;
    }
}
