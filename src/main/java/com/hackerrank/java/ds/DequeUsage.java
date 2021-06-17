package com.hackerrank.java.ds;

import java.util.*;

public class DequeUsage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Long> deque = new ArrayDeque<>();
        Map<Long, Integer> unique = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();


        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            unique.computeIfPresent(num, (e, v) -> v + 1);
            unique.putIfAbsent(num, 1);
            if (deque.size() < m) {
                if (deque.size() == m - 1) {
                    maxUnique = unique.size();
                }
            } else {
                final long removed = deque.removeFirst();
                final Integer val = unique.get(removed);
                if (val == 1) {
                    unique.remove(removed);
                } else {
                    unique.put(removed, val - 1);
                }
                if (unique.size() > maxUnique) {
                    maxUnique = unique.size();
                }
            }
            deque.add(num);
        }
        System.out.println(maxUnique);
    }
}
