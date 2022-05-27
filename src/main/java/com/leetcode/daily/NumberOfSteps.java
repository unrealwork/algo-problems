package com.leetcode.daily;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * <br/>
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero">Task</a>
 *
 * @author unrealwork
 */
public class NumberOfSteps {
    private NumberOfSteps() {

    }

    public static int numberOfSteps(int num) {
        int res = num;
        int count = 0;
        while (res != 0) {
            if (res % 2 == 0) {
                res /= 2;
            } else {
                res--;
            }
            count++;
        }
        return count;
    }
}
