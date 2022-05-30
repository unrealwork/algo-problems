package com.leetcode.string;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

final class BackspaceStringCompare {
    private BackspaceStringCompare() {

    }

    public static boolean backspaceCompare(String s, String t) {
        return Objects.equals(asString(s), asString(t));
    }

    private static Collection<Character> asString(String backspaceString) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < backspaceString.length(); i++) {
            char c = backspaceString.charAt(i);
            if (c == '#') {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(c);
            }
        }
        return deque;
    }
}
