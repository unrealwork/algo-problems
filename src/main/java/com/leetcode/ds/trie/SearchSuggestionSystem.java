package com.leetcode.ds.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SearchSuggestionSystem {
    private SearchSuggestionSystem() {
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (int i = 0; i < products.length; i++) {
            trie.insert(products, i);
        }
        Trie.TrieNode it = trie.root;
        List<List<String>> res = new ArrayList<>(searchWord.length());
        for (int i = 0; i < searchWord.length(); i++) {
            if (it == null) {
                res.add(Collections.emptyList());
            } else {
                it = it.nodes[searchWord.charAt(i) - 'a'];
                res.add(suggestion(it, products));
            }
        }
        return res;
    }

    private List<String> suggestion(Trie.TrieNode trieNode, String[] words) {
        Deque<Trie.TrieNode> stack = new LinkedList<>();
        List<String> res = new ArrayList<>(3);
        if (trieNode != null) {
            stack.add(trieNode);
        }
        while (!stack.isEmpty() && res.size() < 3) {
            Trie.TrieNode curNode = stack.removeLast();
            if (curNode.isTerminal()) {
                res.add(words[curNode.wordIndex]);
            }
            for (int i = curNode.nodes.length - 1; i >= 0; i--) {
                if (curNode.nodes[i] != null) {
                    stack.addLast(curNode.nodes[i]);
                }
            }
        }
        return res;
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
