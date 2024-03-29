package com.leetcode.dp;

import java.util.Arrays;

final class MatchStickToSquare {
    private MatchStickToSquare() {
        
    }
    static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int max = matchsticks[0];
        for (int matchstick : matchsticks) {
            sum += matchstick;
            max = Math.max(matchstick, max);
        }
        if (sum % 4 != 0 || matchsticks.length < 4) {
            return false;
        }
        int target = sum / 4;
        if (max > target) {
            return false;
        }
        Arrays.sort(matchsticks);
        return makeSquareRec(matchsticks, new int[4], target, matchsticks.length - 1);
    }

    private static boolean makeSquareRec(int[] mathsticks, int[] buckets, int target, int curIndex) {
        if (curIndex < 0) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] += mathsticks[curIndex];
            if (buckets[i] <= target && makeSquareRec(mathsticks, buckets, target, curIndex - 1)) {
                return true;
            } else {
                buckets[i] -= mathsticks[curIndex];
            }
        }
        return false;
    }

}
