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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
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
    int[] dict1 = IntStream.rangeClosed(1, 100).map(i -> i * i).toArray();
//    os.println(solve2(dict1, 50));
    os.println(solve2(dict, k));
    return os;
  }

  static class State implements Comparable<State> {

    int[] dict;
    int sum;
    int lastAddedIndex;
    int length;
    int lastIndex;
    boolean isBad = false;
    long waysCount = 1;

    State(int[] dict, int sum, int prevElement, int length) {
      this.dict = dict;
      this.sum = sum;
      this.lastAddedIndex = prevElement;
      this.length = length;
      this.lastIndex = dict.length;
    }

    public State add(int index) {
      State state = new State(dict, sum + dict[index], index, length + 1);
      state.waysCount = waysCount;
      return state;
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
          lastAddedIndex == state.lastAddedIndex &&
          length == state.length;
    }

    @Override
    public int hashCode() {

      return Objects.hash(sum, lastAddedIndex, length);
    }

    public boolean isBad() {
      return isBad;
    }

    @Override
    public String toString() {
      return String.format("[%d-%d-%d", sum, lastAddedIndex, length);
    }

    @Override
    public int compareTo(State o) {
      if (this.equals(o)) {
        return 0;
      } else {
        int res = Integer.compare(sum, o.sum);
        if (res != 0) {
          return res;
        } else {
          return Integer.compare(lastAddedIndex, o.lastAddedIndex);
        }
      }
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
      if (state.length == k && state.isBad) {
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
              nextState.isBad = true;
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

  public long solve2(int[] dict, int k) {
    Map<Integer, State> statesDict = new HashMap<>();
    for (int i = 0; i < dict.length - k + 1; i++) {
      statesDict.put(i, new State(dict, dict[i], i, 1));
    }
    TreeSet<State> states = IntStream.range(0, dict.length - k + 1)
        .mapToObj(i -> new State(dict, dict[i], i, 1))
        .collect(Collectors.toCollection(TreeSet::new));
    int result = 0;
    Map<Integer, Boolean> checker = new HashMap<>();
    for (int i = 1; i < k; i++) {
      TreeSet<State> nextStates = new TreeSet<>();
      for (State state : states) {
        for (int j = state.lastAddedIndex + 1; j < state.lastIndex - k + i + 1;
            j++) {
          State nextState = state.add(j);
          nextStates.add(nextState);
        }
      }
      if (i + 1 < k) {
        Optional<Integer> limit = Optional.empty();
        Iterator<State> it = nextStates.iterator();
        Optional<State> lastAdded = Optional.empty();
        boolean hasDuplicate = false;
        while (it.hasNext()) {
          State state = it.next();
          if (!limit.isPresent()) {
            limit = Optional.of(state.sum);
            lastAdded = Optional.of(state);
          } else {
            if (limit.get().equals(state.sum)) {
              if (!hasDuplicate) {
                lastAdded.get().lastIndex = state.lastAddedIndex;
                hasDuplicate = true;
              }
            } else {
              lastAdded = Optional.of(state);
              limit = Optional.of(state.sum);
              hasDuplicate = false;
            }
          }
          if (i < (k - 1)) {
            nextStates.removeIf(s -> s.isBad);
          }
        }
      }
      states = nextStates;
    }
    return uniqueSum(states);

  }

  private long uniqueSum(Set<State> states) {
    Map<Integer, Boolean> holder = new HashMap<>();
    long res = 0;
    for (State s : states) {
      if (holder.containsKey(s.sum)) {
        if (holder.get(s.sum)) {
          holder.put(s.sum, false);
        }
      } else {
        if (!s.isBad) {
          holder.put(s.sum, true);
        }
      }
    }
    return holder.entrySet().stream().filter(Entry::getValue)
        .mapToInt(Entry::getKey).sum();

  }

  public static void main(String[] args) {
    new UniqueSumSubset().solve(System.in, System.out);
  }
}
