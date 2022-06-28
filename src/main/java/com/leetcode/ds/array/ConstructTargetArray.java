package com.leetcode.ds.array;

import java.util.Comparator;
import java.util.PriorityQueue;

class ConstructTargetArray {
    private ConstructTargetArray() {

    }

    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int num : target) {
            sum += num;
            heap.add(num);
        }
        int rest = sum - heap.peek();
        while (!heap.isEmpty() && heap.peek() > 1) {
            int largest = heap.remove();
            if (rest >= 1 && rest < largest) {
                int newAdded = largest % rest;
                newAdded = newAdded == 0 ? rest : newAdded;
                heap.add(newAdded);
                rest -= heap.peek();
                rest += newAdded;
            } else {
                return false;
            }
        }
        return true;
    }
}
