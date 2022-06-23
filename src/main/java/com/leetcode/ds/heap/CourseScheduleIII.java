package com.leetcode.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class CourseScheduleIII {
    private CourseScheduleIII() {

    }

    public static int scheduleCourse(int[][] courses) {
        int currentTotalDuration = 0;
        PriorityQueue<Integer> durations = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(courses, Comparator.comparing((int[] c) -> c[1]));
        for (int[] c : courses) {
            int duration = c[0];
            int lastDay = c[1];
            if (duration <= lastDay) {
                if (currentTotalDuration + duration <= lastDay) {
                    currentTotalDuration += duration;
                    durations.add(duration);
                } else {
                    if (!durations.isEmpty() && durations.peek() > duration && 
                            currentTotalDuration - durations.peek() + duration <= lastDay) {
                        currentTotalDuration += (duration - durations.remove());
                        durations.add(duration);
                    }
                }
            }
        }
        return durations.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        System.out.println(scheduleCourse(courses));
    }
}
