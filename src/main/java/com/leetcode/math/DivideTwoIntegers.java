package com.leetcode.math;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <br>
 * <a href="">Divide Two Integers</a>
 *
 * @author unrealwork
 */
final class DivideTwoIntegers {
    private DivideTwoIntegers() {

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (divisor == Integer.MIN_VALUE || dividend == 0) {
            return 0;
        }
        return handleMainCase(dividend, divisor);
    }

    private static int handleMainCase(int dividend, int divisor) {
        int res = 0;
        int quotient = 0;
        int absDividend = dividend != Integer.MIN_VALUE ? Math.abs(dividend) : Integer.MAX_VALUE;
        int absDivisor = Math.abs(divisor);
        boolean isPositive = sign(dividend, divisor);
        Map<Integer, Integer> shiftMap = shiftMap(absDividend, absDivisor);
        Iterator<Map.Entry<Integer, Integer>> it = shiftMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<Integer, Integer> kv = it.next();
            int mult = kv.getKey();
            int val = kv.getValue();
            while (it.hasNext()) {
                if ((Integer.MAX_VALUE - res) >= val && res + val <= absDividend) {
                    res += val;
                    quotient += mult;
                } else {
                    kv = it.next();
                    mult = kv.getKey();
                    val = kv.getValue();
                }
            }

        }
        while ((Integer.MAX_VALUE - res >= absDivisor) && (res + absDivisor <= absDividend)) {
            res += absDivisor;
            quotient++;
        }
        if (dividend == Integer.MIN_VALUE && (Integer.MIN_VALUE + res <= absDivisor) &&
                -res - divisor == dividend) {
            return -(quotient + 1);
        }
        return isPositive ? quotient : -quotient;
    }

    private static boolean sign(int dividend, int divisor) {
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
    }


    private static Map<Integer, Integer> shiftMap(int absDividend, int absDivisor) {
        int res = absDivisor;
        Map<Integer, Integer> shiftMap = new TreeMap<>(Comparator.reverseOrder());
        int mult = 1;
        while ((Integer.MAX_VALUE - res >= absDivisor) && (res <= absDividend)) {
            shiftMap.put(mult, res);
            res = res << 1;
            mult = mult << 1;
        }
        return shiftMap;
    }
}
