package com.leetcode.slidingwindow;

import scala.Char;

import java.util.Arrays;
import java.util.Map;

class LongestSubstringWithAtLeastKDistinctChars {
    private LongestSubstringWithAtLeastKDistinctChars() {

    }

    public static int longestSubstring(String s, int k) {
        int windowStart = 0;
        int curCount = 0;
        int best = 0;
        int[] dict = new int['z' + 1];
        return best;
    }

    private static boolean isFilled(int[] dict, int k) {
        for (int i = 'a'; i < dict.length; i++) {
            if (dict[i] > 0 && dict[i] < k) {
                return false;
            }
        }
        return true;
    }
}
