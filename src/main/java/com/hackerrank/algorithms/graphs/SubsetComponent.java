package com.hackerrank.algorithms.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class SubsetComponent {


  public static final BigInteger TWO = BigInteger.valueOf(2);

  static long subsetComponent(List<Long> nums) {
    return new Solver(nums).result();
  }


  static class Solver {

    private long res;
    private Map<Long, Integer> edgesMap;

    Solver(List<Long> nums) {
      this.res = 64;
      this.edgesMap = new HashMap<>();
      for (Long num : nums) {
        int vCount = Long.bitCount(num);
        edgesMap.put(num, vCount);
      }
      Stack<Long> numsStack = new Stack<>();
      numsStack.addAll(nums);
      countSubsetComponent(new ArrayList<>(), numsStack);
    }

    private long bits(BigInteger num) {
      return num.toString(2).chars().filter(c -> c == '1').count();
    }

    private void countSubsetComponent(List<Long> components,
        Stack<Long> nums) {
      while (!nums.isEmpty()) {
        long num = nums.pop();
        Stack<Long> nextStack = new Stack<>();
        nextStack.addAll(nums);
        List<Long> newComponents = new ArrayList<>();
        int rest = 64;
        long it = num;
        for (long component : components) {
          long or = num | component;
          if (or != 0 && (component & num) == 0) {
            newComponents.add(component);
            rest += (-edgesMap.get(component) + 1);
          } else {
            it = or;
          }
        }
        if (!edgesMap.containsKey(it)) {
          edgesMap.put(it, Long.bitCount(it));
        }
        newComponents.add(it);
        if (it != 0) {
          rest += (-edgesMap.get(it) + 1);
        }
        res += rest;
        countSubsetComponent(newComponents, nextStack);
      }
    }

    public long result() {
      return res;
    }

  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      reader.readLine();
      List<Long> numbers = Arrays.stream(reader.readLine().split("\\s"))
          .map(BigInteger::new).map(BigInteger::longValue)
          .collect((Collectors.toList()));
      System.out.println(subsetComponent(numbers));
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}

