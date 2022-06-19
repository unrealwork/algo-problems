package com.leetcode.string;


import java.util.Arrays;

class IsomorphicStrings {
    private IsomorphicStrings() {

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sDict = indexMap(s);
        int[] tDict = indexMap(t);
        for (int i = 1; i < s.length(); i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            if (sDict[sCur] == tDict[tCur]) {
                return false;
            }
            sDict[sCur] = i;
            tDict[tCur] = i;
        }
        return true;
    }

    private static int[] indexMap(String s) {
        int[] indexDict = new int[256];
        Arrays.fill(indexDict, -1);
        indexDict[s.charAt(0)] = 0;
        return indexDict;
    }
}
