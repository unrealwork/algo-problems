package com.leetcode.ds.trie;


import java.util.Deque;
import java.util.LinkedList;

class WordFilter {
    private final Trie trie;
    private final String[] words;

    public WordFilter(String[] words) {
        trie = trie(words);
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        Deque<Trie.TrieNode> trieNode = new LinkedList<>();
        Trie.TrieNode prefixNode = trie.prefixNode(prefix);
        if (prefixNode != null) {
            trieNode.add(prefixNode);
        }
        int res = -1;
        while (!trieNode.isEmpty()) {
            Trie.TrieNode node = trieNode.removeLast();
            if (node.isTerminal()) {
                if (words[node.wordIndex].endsWith(suffix)) {
                    res = Math.max(res, node.wordIndex);
                }
            } else {
                for (int i = 0; i < node.nodes.length; i++) {
                    Trie.TrieNode nextNode = node.nodes[i];
                    if (nextNode != null) {
                        trieNode.addFirst(nextNode);
                    }
                }
            }
        }
        return res;
    }

    private static Trie trie(String... words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words, i);
        }
        return trie;
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] words, int index) {
            String word = words[index];
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
            parent.wordIndex = index;
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

            public void setWordIndex(int wordIndex) {
                this.wordIndex = wordIndex;
            }

            private int wordIndex = -1;

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
                return wordIndex > -1;
            }

            boolean hasChild(char c) {
                return getChild(c) != null;
            }
        }
    }
}
