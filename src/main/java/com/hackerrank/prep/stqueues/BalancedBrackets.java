package com.hackerrank.prep.stqueues;


import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {


    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            //Complete the code
            System.out.println(isValid(input) ? "YES" : "NO");
        }

    }

    private static boolean isValid(final String s) {
        final Stack<Parenthesis> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            final Parenthesis curP = Parenthesis.from(c);
            if (stack.isEmpty()) {
                if (curP.isOpen(c)) {
                    stack.push(curP);
                } else {
                    return false;
                }
            } else {
                final Parenthesis lastP = stack.peek();
                if (lastP == curP) {
                    if (!curP.isOpen(c)) {
                        stack.pop();
                    } else {
                        stack.push(curP);
                    }
                } else {
                    if (curP.isOpen(c)) {
                        stack.push(curP);
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static enum Parenthesis {
        CURLY('{', '}'), SQUARE('[', ']'), SIMPLE('(', ')');
        private final char openSymbol;
        private final char closeSymbol;

        Parenthesis(final char open, final char close) {
            openSymbol = open;
            closeSymbol = close;
        }

        public boolean isOpen(char c) {
            return c == openSymbol;
        }

        public static Parenthesis from(char c) {
            for (Parenthesis p : Parenthesis.values()) {
                if (p.closeSymbol == c || p.openSymbol == c) {
                    return p;
                }
            }
            throw new IllegalStateException();
        }
    }
}






