package com.leetcode.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.IntBinaryOperator;

/**
 * @author unrealwork
 */
final class EvaluateReversePolishNotation {
    private EvaluateReversePolishNotation() {

    }


    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>(tokens.length);
        for (String t : tokens) {
            Operation op = Operation.fromString(t);
            if (op != null) {
                Integer b = deque.removeLast();
                Integer a = deque.removeLast();
                int res = op.apply(a, b);
                deque.addLast(res);
            } else {
                deque.addLast(Integer.parseInt(t));
            }
        }
        return deque.removeLast();
    }

    private enum Operation {
        /**
         * Addition
         */
        PLUS('+', (a, b) -> a + b),
        /**
         * Subtraction
         */
        MINUS('-', (a, b) -> a - b),
        /**
         * Multiplication
         */
        TIMES('*', (a, b) -> a * b),
        /**
         * Division
         */
        DIV('/', (a, b) -> a / b);
        private final char c;
        private final IntBinaryOperator binaryOperator;


        Operation(char c, IntBinaryOperator binaryOperator) {
            this.c = c;
            this.binaryOperator = binaryOperator;
        }

        public static Operation fromString(String token) {
            if (token.length() == 1) {
                char t = token.charAt(0);
                for (Operation value : values()) {
                    if (value.c == t) {
                        return value;
                    }
                }
            }
            return null;
        }

        int apply(int a, int b) {
            return binaryOperator.applyAsInt(a, b);
        }
    }
}
