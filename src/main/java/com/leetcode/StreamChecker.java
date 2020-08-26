package com.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StreamChecker {
    private final Trie trie;
    private LinkedList<Trie.Node> matchingNodes;

    public StreamChecker(String[] words) {
        this.trie = Trie.newInstance(words);
        this.matchingNodes = new LinkedList<>();
    }

    public boolean query(char letter) {
        final Iterator<Trie.Node> it = matchingNodes.iterator();
        final List<Trie.Node> nextNodes = new LinkedList<>();
        boolean hasWord = false;
        while (it.hasNext()) {
            Trie.Node node = it.next();
            final Trie.Node nextNode = node.get(letter);
            if (nextNode != null) {
                nextNodes.add(nextNode);
                if (!hasWord && nextNode.isTerminal()) {
                    hasWord = true;
                }
            }
            it.remove();
        }
        matchingNodes.addAll(nextNodes);
        if (trie.getStorage().containsKey(letter)) {
            Trie.Node nextNode = trie.getStorage().get(letter);
            matchingNodes.add(nextNode);
            if (!hasWord && nextNode.isTerminal()) {
                hasWord = true;
            }
        }
        return hasWord;
    }
}


class Trie {
    private final Map<Character, Trie.Node> storage;
    private final int depth;


    private Trie(String[] words) {
        int maxLength = -1;
        final Map<Character, Node> storage = new HashMap<>();
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            insert(word, storage);
        }
        this.depth = maxLength;
        this.storage = Collections.unmodifiableMap(storage);
    }

    private static void insert(final String word, final Map<Character, Node> storage) {
        Node node = null;
        int length = word.length();
        if (length > 0) {
            node = storage.computeIfAbsent(word.charAt(0), s -> Node.of(s, length == 1));
        }
        for (int i = 1; i < length; i++) {
            char symbol = word.charAt(i);
            if (node != null) {
                node = node.addNode(symbol, i == length - 1);
            }
        }
    }

    public static Trie newInstance(String... words) {
        return new Trie(words);
    }

    public int getDepth() {
        return depth;
    }

    public Map<Character, Node> getStorage() {
        return storage;
    }

    static class Node {
        private final char symbol;
        private final Map<Character, Node> nodes;
        private final boolean isTerminal;

        private Node(final char symbol, boolean isTerminal) {
            this(symbol, new HashMap<>(), isTerminal);
        }

        private Node(final char symbol, Map<Character, Node> children, boolean isTerminal) {
            this.symbol = symbol;
            this.nodes = new HashMap<>(children);
            this.isTerminal = isTerminal;
        }

        public static Node of(final char symbol, boolean isTerminal) {
            return new Node(symbol, isTerminal);
        }

        public static Node of(final char symbol, Map<Character, Node> children, boolean isTerminal) {
            return new Node(symbol, children, isTerminal);
        }

        public Collection<Node> children() {
            return nodes.values();
        }

        public Trie.Node get(final char symbol) {
            return nodes.getOrDefault(symbol, null);
        }

        public Node addNode(final char symbol, final boolean isTerminal) {

            Node node = this.nodes.computeIfAbsent(symbol, s -> Node.of(s, isTerminal));
            if (isTerminal) {
                Node nodeToReplace = this.nodes.containsKey(symbol) ? Node.of(symbol, this.get(symbol).nodes, true) : Node.of(symbol, true);
                this.nodes.put(symbol, nodeToReplace);
            }
            return node;

        }

        public char getSymbol() {
            return symbol;
        }

        public boolean isTerminal() {
            return isTerminal;
        }
    }
}



