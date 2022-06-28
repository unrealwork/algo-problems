package com.leetcode.ds.array;

class MaximumPointsYouCanObtain {
    private MaximumPointsYouCanObtain() {

    }

    public static int maxScore(int[] cardPoints, int k) {
        int windowSize = cardPoints.length - k;
        int curSum = 0;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            curSum += cardPoints[i];
            sum += cardPoints[i];
        }
        int minSum = curSum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            curSum += (-cardPoints[i - windowSize] + cardPoints[i]);
            minSum = Math.min(curSum, minSum);
        }
        return sum - minSum;
    }
}
