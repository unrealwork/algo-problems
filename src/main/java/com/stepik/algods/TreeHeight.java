package com.stepik.algods;

import java.util.*;

public class TreeHeight {

    private static class Tree {
        private List<List<Integer>> tree;
        private int root = -1;

        private Tree(int[] t) {
            tree = new ArrayList<>(t.length);
            for (int i = 0; i < t.length; i++) {
                tree.add(null);
            }
            for (int i = 0; i < t.length; i++) {
                final int parent = t[i];
                if (parent == -1) {
                    this.root = i;
                } else {
                    validateNode(parent);
                    List<Integer> children = tree.get(parent);
                    if (Objects.isNull(children)) {
                        LinkedList<Integer> c = new LinkedList<>();
                        c.add(i);
                        tree.set(parent, c);
                    } else {
                        children.add(i);
                    }
                }
            }
            if (root < 0) {
                throw new IllegalArgumentException("The tree should contain root!");
            }
        }

        private void validateNode(int parent) {
            if (parent < 0 || parent >= tree.size()) {
                throw new IllegalStateException(String.format("%s is not valid node", parent));
            }
        }

        List<Integer> children(final int node) {
            validateNode(node);
            return tree.get(node);
        }

        public int getRoot() {
            return root;
        }

        public int size() {
            return tree.size();
        }
    }


    private static class Solver {
        private final Tree tree;
        private final int[] memo;
        private final int result;

        Solver(Tree tree) {
            this.tree = tree;
            this.memo = new int[tree.size()];
            this.result = solve();
        }

        private int solve() {
            return height(tree.getRoot());
        }

        private int height(final int n) {
            if (memo[n] > 0) {
                return memo[n];
            }
            // Not calculated yet
            List<Integer> children = tree.children(n);
            if (children == null) {
                memo[n] = 1;
            } else {
                for (int ch : children) {
                    height(ch);
                }
                children.stream().mapToInt(node -> memo[node]).max()
                        .ifPresent(res -> memo[n] = res + 1);
            }
            return memo[n];
        }

        public int getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int n = scanner.nextInt();
            final int[] tree = new int[n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = scanner.nextInt();
            }
            final int height = solve(tree);
            System.out.println(height);
        }
    }

    static int solve(int[] tree) {
        final Solver solver = new Solver(new Tree(tree));
        return solver.getResult();
    }
}
