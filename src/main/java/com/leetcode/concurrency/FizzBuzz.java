package com.leetcode.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

@SuppressWarnings("squid:S106")
public class FizzBuzz {

  private volatile int cur;
  private int n;

  public FizzBuzz(int n) {
    this.n = n;
    this.cur = 1;
  }

  public static void main(String[] args) throws InterruptedException {
    FizzBuzz fizzBuzz = new FizzBuzz(15);
    List<Thread> threadList =
        Arrays.asList(
            new Thread(
                InterruptedRunnable.asRunnable(
                    () -> fizzBuzz.fizz(() -> System.out.println("fizz")))),
            new Thread(
                InterruptedRunnable.asRunnable(
                    () -> fizzBuzz.buzz(() -> System.out.println("buzz")))),
            new Thread(
                InterruptedRunnable.asRunnable(
                    () -> fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz")))),
            new Thread(InterruptedRunnable.asRunnable(() -> fizzBuzz.number(System.out::println))));
    threadList.forEach(Thread::start);
    for (Thread thread : threadList) {
      thread.join();
    }
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    action(i -> i % 3 == 0 && i % 5 != 0, i -> printFizz.run());
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    action(i -> i % 5 == 0 && i % 3 != 0, i -> printBuzz.run());
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    action(i -> i % 5 == 0 && i % 3 == 0, i -> printFizzBuzz.run());
  }

  public void number(IntConsumer printNumber) throws InterruptedException {
    action(i -> i % 5 != 0 && i % 3 != 0, printNumber);
  }

  public synchronized void action(IntPredicate predicate, IntConsumer action)
      throws InterruptedException {
    try {
      while (cur <= n) {
        if (predicate.test(cur)) {
          action.accept(cur);
          cur++;
          notifyAll();
        } else {
          wait();
        }
      }
    } finally {
      notifyAll();
    }
  }

  @FunctionalInterface
  private interface InterruptedRunnable {
    static Runnable asRunnable(InterruptedRunnable runnable) {
      return () -> {
        try {
          runnable.run();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IllegalStateException(e);
        }
      };
    }

    void run() throws InterruptedException;
  }
}
