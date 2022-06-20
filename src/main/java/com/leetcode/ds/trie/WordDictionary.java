package com.leetcode.ds.trie;

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, 0, root);
    }

    private boolean search(String prefix, int startIndex, TrieNode rootNode) {
        TrieNode it = rootNode;
        for (int i = startIndex; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (c == '.') {
                return searchWildCard(prefix, it, i);
            }
            TrieNode child = it.getChild(c);
            if (child == null) {
                return false;
            }
            it = child;
        }
        return it.isTerminal;
    }

    private boolean searchWildCard(String prefix, TrieNode it, int i) {
        for (TrieNode node : it.nodes) {
            if (node != null) {
                boolean searchRes = search(prefix, i + 1, node);
                if (searchRes) {
                    return true;
                }
            }
        }
        return false;
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

    }
}
