package com.leetcode.bits;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <br>
 * 
 * <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 * @author unrealwork
 */
public final class CountingBits {
    private CountingBits() {
        
    }

    public static final int BASE = 2;

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n > 0) {
            int powOfTwo = 1;
            int nextPowOfTwo = BASE;
            res[1] = 1;
            for (int i = BASE; i < res.length; i++) {
                if (i == nextPowOfTwo) {
                    powOfTwo = nextPowOfTwo;
                    nextPowOfTwo <<= 1;
                }
                res[i] = res[i - powOfTwo] + 1;
            }
        }
        return res;
    }
}
