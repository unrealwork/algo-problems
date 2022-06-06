package com.leetcode.math;

class PowXn {

    private PowXn() {
    }

    public static double myPow(double x, int n) {
        double xn = n < 0 ? 1 / x : x;
        long pow = 1;
        double res = 1;
        final long absN = Math.abs((long) n);
        while (pow <= absN) {
            if ((pow & absN) != 0) {
                res *= xn;
            }
            xn *= xn;
            pow = pow << 1;
        }
        return res;
    }
}
