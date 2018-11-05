package com.stepik.algods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MaxStack {
    private static class Commands {
        public static final String MAX = "max";
        static final String PUSH = "push ";
        static final String POP = "pop";
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, UTF_8))) {
            MStack<Long> maxStack = new MStack<>();
            final long lines = Long.parseLong(reader.readLine().trim());
            for (long i = 0; i < lines; i++) {
                final String line = reader.readLine();
                if (line.startsWith(Commands.PUSH)) {
                    Long n = Long.parseLong(line.substring(Commands.PUSH.length()));
                    maxStack.push(n);
                } else {
                    if (line.startsWith(Commands.POP)) {
                        maxStack.pop();
                    } else {
                        System.out.println(maxStack.max());
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static class MStack<T extends Comparable<T>> {
        private Stack<T> stack = new Stack<>();
        private Stack<T> maxStack = new Stack<>();

        public void push(T e) {
            stack.push(e);
            if (maxStack.isEmpty()) {
                maxStack.push(e);
            } else {
                T max = maxStack.peek();
                if (max.compareTo(e) <= 0) {
                    maxStack.push(e);
                }
            }
        }

        public void pop() {
            T poped = stack.pop();
            T peek = maxStack.peek();
            if (poped.compareTo(peek) == 0) {
                maxStack.pop();
            }
        }

        public T max() {
            return maxStack.peek();
        }
    }


}
