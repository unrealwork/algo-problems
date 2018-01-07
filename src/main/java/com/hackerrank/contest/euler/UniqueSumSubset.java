package com.hackerrank.contest.euler;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueSumSubset implements Solution {

  private static boolean[] used;
  private Map<Integer, Boolean> holder = new HashMap<>();
  private BigInteger res = BigInteger.ZERO;
  private static long count = 0;
  private Set<State> stateHolder = new HashSet<>();

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] dict = IntStream.range(0, n).map(i -> in.nextInt()).sorted()
        .toArray();
//    permutation(new int[k], 0, 0, dict, 0);
//    os.println(res);
    print(new int[k], 0, 0, dict, 0);
    os.println(solve(dict, k));
    return os;
  }

  static class State {

    int[] dict;
    int sum;
    int lastAddedIndex;
    int length;
    int lastIndex;

    State(int[] dict, int sum, int prevElement, int length) {
      this.dict = dict;
      this.sum = sum;
      this.lastAddedIndex = prevElement;
      this.length = length;
      this.lastIndex = dict.length;
    }

    public State add(int index) {
      return new State(dict, sum + dict[index], index, length + 1);
    }

    public boolean isSame(State state) {
      return (state != this && length == state.length
          && sum == state.sum && lastAddedIndex != state.lastAddedIndex);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      State state = (State) o;
      return sum == state.sum &&
          length == state.length;
    }

    @Override
    public int hashCode() {

      return Objects.hash(sum, length);
    }

    @Override
    public String toString() {
      return String.format("[%d-%d-%d", sum, lastAddedIndex, length);
    }

  }

  public void print(int[] perm, int start, int k, int[] dict,
      int sum) {
    if (k == perm.length) {
      System.out.println(Arrays.toString(perm) + " = " + sum);
    } else {
      for (int i = start; i < dict.length; i++) {
        perm[k] = dict[i];
        print(perm, i + 1, k + 1, dict, sum + dict[i]);
      }
    }
  }

  public void permutation(int[] perm, int start, int k, int[] dict,
      int sum) {
    if (k == perm.length) {
      if (!holder.containsKey(sum)) {
        holder.put(sum, true);
        res = res.add(BigInteger.valueOf(sum));
      } else {
        boolean isFirstAdd = holder.get(sum);
        if (isFirstAdd) {
          res = res.subtract(BigInteger.valueOf(sum));
          holder.put(sum, false);
        }
      }
    } else {
      for (int i = start; i < dict.length; i++) {
        perm[k] = dict[i];
        permutation(perm, i + 1, k + 1, dict, sum + dict[i]);
      }
    }
  }

  public static long solve(int[] dict, int k) {
    long result = 0;
    Queue<State> queue = IntStream.range(0, dict.length)
        .mapToObj(i -> new State(dict, dict[i], i, 1)).collect(
            Collectors.toCollection(ArrayDeque::new));
    while (!queue.isEmpty()) {
      State state = queue.remove();
      if (state.length == k) {
        result += state.sum;
      } else {
        for (int i = state.lastAddedIndex + 1; i < state.lastIndex; i++) {
          State nextState = state.add(i);
          boolean isBadState = false;
          Iterator<State> stateIterator = queue.iterator();
          while (stateIterator.hasNext()) {
            State s = stateIterator.next();
            if (nextState.isSame(s)) {
              isBadState = true;
              nextState.lastIndex = s.lastAddedIndex + 1;
              stateIterator.remove();
            }
          }
          if (nextState.length == k) {
            if (!isBadState) {
              queue.add(nextState);
            }
          } else {
            queue.add(nextState);
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    new UniqueSumSubset().solve(System.in, System.out);
  }
}