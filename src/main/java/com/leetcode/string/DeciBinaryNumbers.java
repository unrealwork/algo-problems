package com.leetcode.string;

class DeciBinaryNumbers {
    private DeciBinaryNumbers() {
        
    }

    public static int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(n.charAt(i) - '0', res);
        }
        return res;
    }
}
