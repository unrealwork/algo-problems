package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CombinationSum {
    private CombinationSum() {
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Solver solver = new Solver(candidates, target);
        return solver.solve();
    }

    private static class Solver {
        private final int[] candidates;
        private final int target;

        private Solver(int[] candidates, int target) {
            this.candidates = Arrays.copyOf(candidates, candidates.length);
            Arrays.sort(candidates);
            this.target = target;
        }

        List<List<Integer>> solve() {
            List<List<Integer>> res = new ArrayList<>();
            for (int candidate : candidates) {
                solve(res, Collections.singletonList(candidate), candidate, candidate);
            }
            return res;
        }

        private void solve(List<List<Integer>> accRes, List<Integer> curSeq, int curSum, int lastAdded) {
            if (curSum < target) {
                for (int candidate : candidates) {
                    if (candidate >= lastAdded) {
                        List<Integer> newSeq = new ArrayList<>(curSeq);
                        newSeq.add(candidate);
                        solve(accRes, newSeq, curSum + candidate, candidate);
                    }
                }
            } else {
                if (curSum == target) {
                    accRes.add(curSeq);
                }
            }
        }
    }
}
