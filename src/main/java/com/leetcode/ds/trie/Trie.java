package com.leetcode.ds.trie;

class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode current = parent.getChild(c);
            if (current != null) {
                parent = current;
            } else {
                TrieNode newNode = new TrieNode();
                parent.addChild(c, newNode);
                parent = newNode;
            }
        }
        parent.setTerminal(true);
    }

    public boolean search(String word) {
        TrieNode prefixNode = prefixNode(word);
        return prefixNode != null && prefixNode.isTerminal();
    }

    public boolean startsWith(String prefix) {
        return prefixNode(prefix) != null;
    }

    private TrieNode prefixNode(String prefix) {
        TrieNode it = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode child = it.getChild(c);
            if (child == null) {
                return child;
            }
            it = child;
        }
        return it;
    }

    private static class TrieNode {
        private final TrieNode[] nodes;

        public void setTerminal(boolean terminal) {
            isTerminal = terminal;
        }

        private boolean isTerminal;

        private TrieNode() {
            this.nodes = new TrieNode['z' - 'a' + 1];
        }


        void addChild(char c, TrieNode node) {
            nodes[c - 'a'] = node;
        }

        TrieNode getChild(char c) {
            return nodes[c - 'a'];
        }

        boolean isTerminal() {
            return isTerminal;
        }

        boolean hasChild(char c) {
            return getChild(c) != null;
        }
    }
}
