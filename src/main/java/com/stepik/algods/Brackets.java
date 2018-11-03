package com.stepik.algods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Stack;

public class Brackets {

    private enum BracketType {
        SIMPLE, SQUARE, CURLY;

        public static BracketType valueOf(char c) {
            switch (c) {
                case '(':
                    return SIMPLE;
                case ')':
                    return SIMPLE;
                case '[':
                    return SQUARE;
                case ']':
                    return SQUARE;
                case '{':
                    return CURLY;
                case '}':
                    return CURLY;
                default:
                    throw new IllegalArgumentException("Not supported bracket");
            }
        }
    }

    private static class Bracket {
        private final long pos;
        private final boolean isOpen;
        private final BracketType type;
        private final char symbol;

        private Bracket(final long pos, final boolean isOpen, final BracketType type, final char symbol) {
            this.pos = pos;
            this.isOpen = isOpen;
            this.type = type;
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return "Bracket{" +
                    "pos=" + pos +
                    ", isOpen=" + isOpen +
                    ", type=" + type +
                    '}';
        }
    }

    private static class BracketFactory {
        static Bracket from(char c, long pos) {
            BracketType type = BracketType.valueOf(c);
            return new Bracket(pos, c == '(' || c == '[' || c == '{', type, c);
        }
    }

    static class Result {
        private final boolean isSuccess;
        private final long pos;


        public static Result SUCCESS = new Result(true, -1);

        private Result(boolean isSuccess, long pos) {
            this.isSuccess = isSuccess;
            this.pos = pos;
        }

        public static Result failed(final long pos) {
            return new Result(false, pos);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return isSuccess == result.isSuccess &&
                    pos == result.pos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(isSuccess, pos);
        }

        @Override
        public String toString() {
            return "Result{" +
                    "isSuccess=" + isSuccess +
                    ", pos=" + pos +
                    '}';
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            final String s = reader.readLine();
            final Result r = solve(s);
            if (r.isSuccess) {
                System.out.println("Success");
            } else {
                System.out.println(r.pos);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    static Result solve(String s) {
        Stack<Bracket> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("([{}])".indexOf(c) < 0) {
                continue;
            }
            final Bracket bracket = BracketFactory.from(c, i + 1);
            if (bracketStack.isEmpty()) {
                if (bracket.isOpen) {
                    bracketStack.push(bracket);
                } else {
                    return Result.failed(bracket.pos);
                }
            } else {
                Bracket peek = bracketStack.peek();
                if (peek.type == bracket.type && peek.isOpen && !bracket.isOpen) {
                    bracketStack.pop();
                } else {
                    if (bracket.isOpen) {
                        bracketStack.push(bracket);
                    } else {
                        return Result.failed(bracket.pos);
                    }
                }
            }
        }
        if (bracketStack.isEmpty()) {
            return Result.SUCCESS;
        } else {
            // TODO: shouldn't work
            Bracket last = bracketStack.pop();
            return Result.failed(last.pos);
        }

    }
}
