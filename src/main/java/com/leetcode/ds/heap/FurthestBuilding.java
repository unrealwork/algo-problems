package com.leetcode.ds.heap;

import java.util.PriorityQueue;

public class FurthestBuilding {
    private FurthestBuilding() {
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int sum = 0;
        int i = 1;
        while (i < heights.length && bricks > 0) {
            if (heights[i] > heights[i - 1]) {
                int diff = heights[i] - heights[i - 1];
                if (heap.size() < ladders) {
                    heap.add(diff);
                } else {
                    if (!heap.isEmpty() && heap.peek() < diff) {
                        Integer maxBricked = heap.remove();
                        if (maxBricked + sum > bricks) {
                            return i - 1;
                        } else {
                            heap.add(diff);
                            sum += maxBricked;
                        }
                    } else {
                        if (diff + sum > bricks) {
                            return i - 1;
                        } else {
                            sum += diff;
                        }
                    }
                }
            }
            i++; 
        }
        return heights.length - 1;
    }
}
