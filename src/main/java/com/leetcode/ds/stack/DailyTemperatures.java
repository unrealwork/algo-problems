package com.leetcode.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class DailyTemperatures {
    private DailyTemperatures() {
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> monoticStack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (monoticStack.isEmpty()) {
                monoticStack.push(i);
            } else {
                while (!monoticStack.isEmpty() && temperatures[monoticStack.peek()] < temperatures[i]) {
                    Integer prevDay = monoticStack.pop();
                    res[prevDay] = i - prevDay;
                }
                monoticStack.push(i);
            }
        }
        return res;
    }
}
