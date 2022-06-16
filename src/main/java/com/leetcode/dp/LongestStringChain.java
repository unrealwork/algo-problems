package com.leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class LongestStringChain {
    private LongestStringChain() {
    }

    public static int longestStrChain(String[] words) {
        List<List<Integer>> wordsByLength = wordsByLength(words);
        int[][] dp = new int[wordsByLength.size() + 1][words.length];
        List<Integer> firstRow = wordsByLength.get(0);
        for (int i = 0; i < firstRow.size(); i++) {
            dp[1][firstRow.get(i)] = 1;
        }
        int maxLength = 1;
        for (int len = 1; len < wordsByLength.size(); len++) {
            List<Integer> prevLevel = wordsByLength.get(len - 1);
            List<Integer> curLevel = wordsByLength.get(len);
            for (Integer curIndex : curLevel) {
                String w1 = words[curIndex];
                dp[w1.length()][curIndex] = 1;
                for (Integer prevIndex : prevLevel) {
                    String w2 = words[prevIndex];
                    if (isPredecessor(w1, w2)) {
                        dp[w1.length()][curIndex] = Math.max(dp[w1.length()][curIndex], dp[w2.length()][prevIndex] + 1);
                    }
                    maxLength = Math.max(maxLength, dp[w1.length()][curIndex]);
                }

            }
        }
        return maxLength;
    }


    private static List<List<Integer>> wordsByLength(String[] words) {
        List<List<Integer>> list = new ArrayList<>(16);
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if (list.size() < length) {
                while (list.size() != length) {
                    list.add(new LinkedList<>());
                }
            }
            list.get(length - 1).add(i);
        }
        return list;
    }

    static boolean isPredecessor(String s, String t) {
        if (s.length() - t.length() != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                i++;
            } else {
                if (i - j <= 1) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == j || i == s.length() && j == t.length();
    }
}
