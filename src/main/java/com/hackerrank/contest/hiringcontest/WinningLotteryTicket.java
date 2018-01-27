package com.hackerrank.contest.hiringcontest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WinningLotteryTicket {

  static final int WIN_COMB = 1023;

  static long winningLotteryTicket(String[] tickets) {
    // Complete this function
    Map<Long, Integer> ticketsPair = new HashMap<>();
    for (String ticket : tickets) {
      long binaryTicket = unique(ticket);
      if (ticketsPair.containsKey(binaryTicket)) {
        ticketsPair.put(binaryTicket, ticketsPair.get(binaryTicket) + 1);
      } else {
        ticketsPair.put(binaryTicket, 1);
      }
    }
    long res = 0;
    long[][] set = ticketsPair.entrySet().stream()
        .map(e -> new long[]{e.getKey(), e.getValue()}).toArray(long[][]::new);
    for (int i = 0; i < set.length; i++) {
      long[] entry = set[i];
      long n = entry[1];
      for (int j = i + 1; j < set.length; j++) {
        if ((entry[0] | set[j][0]) == WIN_COMB) {
          long k = set[j][1];
          res += n * k;
        }

      }
      if (entry[0] == WIN_COMB) {
        res += ((n * (n - 1)) / 2);
      }
    }
    return res;
  }

  static long winningLotteryTicket1(String[] tickets) {
    // Complete this function
    int res = 0;
    long[] bitTickets = Arrays.stream(tickets)
        .mapToLong(WinningLotteryTicket::unique).toArray();
    for (int i = 0; i < tickets.length; i++) {
      for (int j = i + 1; j < tickets.length; j++) {
        if ((bitTickets[i] | bitTickets[j]) == WIN_COMB) {
          res++;
        }
      }
    }
    return res;
  }

  public static long unique(String s) {
    boolean[] ticket = new boolean[10];
    s.chars().distinct().forEach(c -> ticket[c - '0'] = true);
    long n = 0;
    for (int i = 0; i < 10; i++) {
      n ^= ((ticket[i] ? 1 : 0) << i);
    }
    return n;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] tickets = new String[n];
    for (int tickets_i = 0; tickets_i < n; tickets_i++) {
      tickets[tickets_i] = in.next();
    }
    long result = winningLotteryTicket(tickets);
    System.out.println(result);
    in.close();
  }
}
