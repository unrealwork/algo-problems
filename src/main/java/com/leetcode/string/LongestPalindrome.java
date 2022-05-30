package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

final class LongestPalindrome {
    private LongestPalindrome() {

    }

    public static int longestPalindrome(String s) {
        final Map<Character, Integer> counters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (!counters.containsKey(symbol)) {
                counters.put(symbol, 1);
            } else {
                counters.computeIfPresent(symbol, (c, count) -> count + 1);
            }
        }
        int res = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> kv : counters.entrySet()) {
            Integer count = kv.getValue();
            if (count % 2 == 0) {
                res += count;
            } else {
                res += (count - 1);
                hasOdd = true;
            }
        }
        return hasOdd ? res + 1 : res;
    }
}
