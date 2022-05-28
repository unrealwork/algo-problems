package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <br>
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 *
 * @author unrealwork
 */
public final class LetterCombinations {
    private LetterCombinations() {

    }


    public static List<String> letterCombinations(String digits) {
        String[] dict = new String[] {
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            res = generate(res, digits.charAt(i), dict);
        }
        List<String> list = new ArrayList<>();
        for (StringBuilder re : res) {
            String toString = re.toString();
            list.add(toString);
        }
        return list;
    }

    private static List<StringBuilder> generate(List<StringBuilder> base, char num, String[] dict) {
        String opts = dict[num - '2'];
        if (base.isEmpty()) {
            List<StringBuilder> res = new ArrayList<>(opts.length());
            for (int i = 0; i < opts.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(opts.charAt(i));
                res.add(sb);
            }
            return res;
        } else {
            List<StringBuilder> res = new ArrayList<>(opts.length() * base.size());
            for (StringBuilder bsb : base) {
                for (int j = 0; j < opts.length(); j++) {
                    StringBuilder sb = new StringBuilder(bsb);
                    sb.append(opts.charAt(j));
                    res.add(sb);
                }
            }
            return res;
        }
    }
}
