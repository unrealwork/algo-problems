package com.leetcode.string;

class RemovePalindromicSubsequences {
    private RemovePalindromicSubsequences() {
    }

    public static int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return isPalindrome(s, 0, s.length() - 1) ? 1 : 2;
    }

    private static boolean isPalindrome(String s, int first, int last) {
        int i = first;
        int j = last;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return j <= i;
    }
}
