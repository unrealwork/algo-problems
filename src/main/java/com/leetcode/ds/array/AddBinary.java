package com.leetcode.ds.array;

final class AddBinary {
    private AddBinary() {
        
    }
    public static String addBinary(String a, String b) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int mem = 0;
        while (i < a.length() || i < b.length()) {
            int aI = 0;
            int bI = 0;
            if (i < a.length()) {
                aI = a.charAt(a.length() -i  - 1) - '0';
            }
            if (i < b.length()) {
                bI = b.charAt(b.length() - i - 1) - '0';
            }
            int sI = aI + bI + mem;
            int resI = sI % 2;
            mem = sI / 2;
            sb.append(resI);
            i++;
        }
        if (mem > 0) {
            sb.append(mem);
        }
        return sb.reverse().toString();
    }
}
