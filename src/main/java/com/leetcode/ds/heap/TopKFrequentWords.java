package com.leetcode.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        final Map<String, Long> counter = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Comparator<String> comparator = Comparator.comparing(counter::get);
        comparator = comparator.reversed().thenComparing(String::compareTo);

        final PriorityQueue<String> heap = new PriorityQueue<>(comparator);

        for (Map.Entry<String, Long> kv : counter.entrySet()) {
            heap.add(kv.getKey());
        }

        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            res.add(heap.remove());
        }
        return res;
    }
}
