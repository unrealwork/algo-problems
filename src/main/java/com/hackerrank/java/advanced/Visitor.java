package com.hackerrank.java.advanced;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        //implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long res = 1;
    private static final int MOD = 1_000_000_007;

    public int getResult() {
        //implement this
        return (int) res;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            res *= node.getValue();
            res %= MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            res *= leaf.getValue();
            res %= MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNodeSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        //implement this
        return Math.abs(evenDepthNodeSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            evenDepthNodeSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Visitor {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            final int n = sc.nextInt();

            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            Color[] colors = new Color[n];
            for (int i = 0; i < n; i++) {
                colors[i] = sc.nextInt() == 1 ? Color.GREEN : Color.RED;
            }
            TreeNode[] nodes = new TreeNode[n];
            Map<Integer, List<Integer>> edges = new HashMap<>();
            int[] leaves = new int[n];
            for (int i = 0; i < (n - 1); i++) {
                final int from = sc.nextInt() - 1;
                final int to = sc.nextInt() - 1;
                leaves[from]++;
                leaves[to]++;
                if (edges.containsKey(from)) {
                    edges.get(from).add(to);
                } else {
                    final List<Integer> list = new LinkedList<>();
                    list.add(to);
                    edges.put(from, list);
                }
                if (edges.containsKey(to)) {
                    edges.get(to).add(from);
                } else {
                    final List<Integer> list = new LinkedList<>();
                    list.add(from);
                    edges.put(to, list);
                }
            }
            final TreeNode root = new TreeNode(x[0], colors[0], 0);
            nodes[0] = root;
            Deque<Integer> dfsStack = new LinkedList<>();
            dfsStack.push(0);
            boolean[] covered = new boolean[n];
            while (!dfsStack.isEmpty()) {
                final int nodeIndex = dfsStack.pop();
                final TreeNode node = nodes[nodeIndex];
                final int depth = node.getDepth();
                for (int i : edges.get(nodeIndex)) {
                    if (!covered[i]) {
                        boolean isLeaf = leaves[i] == 1;
                        if (!isLeaf) {
                            final TreeNode child = new TreeNode(x[i], colors[i], depth + 1);
                            node.addChild(child);
                            nodes[i] = child;
                            dfsStack.push(i);
                        } else {
                            covered[i] = true;
                            node.addChild(new TreeLeaf(x[i], colors[i], depth + 1));
                        }
                    }
                }
                covered[nodeIndex] = true;
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
