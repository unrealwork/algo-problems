package com.hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class IceCreamParlor {

  public static class Pair<T extends Comparable<T>> {

    private T fisrt;
    private T second;


    public Pair(T first, T second) {
      if (first.compareTo(second) > 0) {
        this.fisrt = second;
        this.second = first;
      } else {
        this.fisrt = first;
        this.second = second;
      }
    }

    public T getFisrt() {
      return fisrt;
    }

    public T getSecond() {
      return second;
    }

    @Override
    public String toString() {
      return String.format("%s %s", fisrt, second);
    }
  }

  public static Pair<Integer> twoSum(int[] arr, int target) {
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i];
      TreeSet<Integer> updatedIndexes = new TreeSet<>(
          Collections.singleton(i));
      if (map.containsKey(a)) {
        TreeSet<Integer> indexes = map.get(a);
        updatedIndexes.addAll(indexes);
        map.put(a, updatedIndexes);
      } else {
        map.put(a, updatedIndexes);
      }
    }
    for (Map.Entry<Integer, TreeSet<Integer>> e : map.entrySet()) {
      Integer key = e.getKey();
      int diff = target - key;
      if (map.containsKey(diff)) {
        TreeSet<Integer> indexes = map.get(diff);
        if (key.equals(diff)) {
          if (indexes.size() > 1) {
            int anotherIndex = -1;
            Integer first = indexes.first();
            for (int index : indexes) {
              if (index != first) {
                anotherIndex = index;
              }
            }
            return new Pair<>(first + 1, anotherIndex + 1);
          }
        } else {
          return new Pair<>(e.getValue().first() + 1, indexes.first() + 1);
        }

      }
    }
    throw new IllegalStateException();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    int testCaseCount = Integer.parseInt(reader.readLine());
    IntStream.range(0, testCaseCount).forEach((testCase) -> {
      try {
        int target = Integer.parseInt(reader.readLine());
        reader.readLine();
        int[] arr = Arrays.stream(reader.readLine().split("\\s"))
            .mapToInt(Integer::parseInt).toArray();
        System.out.println(twoSum(arr, target));
      } catch (IOException e) {
        throw new IllegalStateException();
      }
    });
  }
}
