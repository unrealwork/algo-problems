package com.leetcode.string;

/**
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
 * <br>
 * <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">Maximum Product of Word Lengths</a>
 *
 * @author unrealwork
 */
public final class MaximumProductWordLengths {
    private MaximumProductWordLengths() {
        
    }

    public static int maxProduct(String[] words) {
        int[] bitMaskMap = bitMaskMap(words);
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((bitMaskMap[i] & bitMaskMap[j]) == 0) {
                    int len1 = words[i].length();
                    int len2 = words[j].length();
                    int curProduct = len1 * len2;
                    if (curProduct > maxProduct) {
                        maxProduct = curProduct;
                    }
                }
            }
        }
        return maxProduct;
    }


    private static int[] bitMaskMap(String[] words) {
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = word(words[i]);
        }
        return res;
    }

    private static int word(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int letterNumber = s.charAt(i) - 'a';
            res |= (1 << letterNumber);
        }
        return res;
    }
}
