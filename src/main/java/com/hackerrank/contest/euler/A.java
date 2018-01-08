package com.hackerrank.contest.euler;

public class A {

  public abstract class B {

    public abstract void abs();
  }


  public class C extends B {

    @Override
    public void abs() {
      new C();
    }
  }

  public static void main(String[] args) {
  }
}
