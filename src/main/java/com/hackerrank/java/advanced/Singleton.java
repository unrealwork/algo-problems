package com.hackerrank.java.advanced;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public String str;

    private Singleton() {

    }

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }
}
