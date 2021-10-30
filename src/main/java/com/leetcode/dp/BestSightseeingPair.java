package com.leetcode.dp;

public class BestSightseeingPair {
  private BestSightseeingPair() {}

  public static int maxScoreSightseeingPair(int[] values) {
    Iteration it = new Iteration(values, 0, 1, 0);
    for (int i = 2; i < values.length; i++) {
      it = it.next(i);
    }
    return it.getScore();
  }

  private static class Iteration {
    private final int[] values;
    private final int bestI;
    private final int bestJ;
    private final int indexScore;
    private final int score;

    private Iteration(int[] values, int bestI, int bestJ, int indexScore) {
      this.values = values;
      this.bestI = bestI;
      this.bestJ = bestJ;
      this.indexScore = indexScore;
      this.score = bestI - bestJ + values[bestI] + values[bestJ];
    }

    public Iteration next(int i) {
      int nextImax = values[i - 1] - 1 > values[indexScore] - (i - indexScore) ? i - 1 : indexScore;
      final int nextScore = score(nextImax, i);
      if (this.score < nextScore) {
        return new Iteration(values, nextImax, i, nextImax);
      } else {
        return new Iteration(values, bestI, bestJ, nextImax);
      }
    }

    private int score(int i, int j) {
      return i - j + values[i] + values[j];
    }

    public int getScore() {
      return score;
    }
  }
}
