package com.leetcode.bits;

/**
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 * <br/>
 * <a href="https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/">Check If a String Contains All Binary Codes of Size K</a>
 *
 * @author unrealwork
 */
final class AllBinaryCodes {
    private AllBinaryCodes() {

    }

    public static boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int size = 1 << k;
        boolean[] res = new boolean[size];
        int curNum = symbol(s.charAt(0));
        int mask = size - 1;
        for (int i = 1; i < k; i++) {
            curNum = (curNum << 1) + symbol(s.charAt(i));
        }
        res[curNum] = true;
        int count = 1;
        for (int i = k; i < s.length(); i++) {
            int b = symbol(s.charAt(i));
            curNum = ((curNum << 1) + b) & mask;
            if (!res[curNum]) {
                res[curNum] = true;
                count++;
            }
        }
        return count == size;
    }


    private static int symbol(char c) {
        return c - '0';
    }
}
