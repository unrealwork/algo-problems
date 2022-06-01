package com.leetcode.ds.array;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author unrealwork
 */
final class SlidingWindowMaximum {
    private SlidingWindowMaximum() {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        MStack<Integer> removedHeap = new MStack<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        res[0] = heap.peek();
        for (int i = 1; i < res.length; i++) {
            int curIndex = i + k - 1;
            removedHeap.push(nums[curIndex - k]);
            while (!heap.isEmpty() && !removedHeap.stack.isEmpty() && Objects.equals(removedHeap.max(), heap.peek())) {
                heap.poll();
                removedHeap.pop();
            }
            heap.add(nums[curIndex]);
            res[i] = heap.peek();
        }
        return res;
    }

    private static class MStack<T extends Comparable<T>> {
        private Stack<T> stack = new Stack<>();
        private Stack<T> maxStack = new Stack<>();

        public void push(T e) {
            stack.push(e);
            if (maxStack.isEmpty()) {
                maxStack.push(e);
            } else {
                T max = maxStack.peek();
                if (max.compareTo(e) <= 0) {
                    maxStack.push(e);
                }
            }
        }

        public void pop() {
            T poped = stack.pop();
            T peek = maxStack.peek();
            if (poped.compareTo(peek) == 0) {
                maxStack.pop();
            }
        }

        public T max() {
            return maxStack.peek();
        }
    }
}
