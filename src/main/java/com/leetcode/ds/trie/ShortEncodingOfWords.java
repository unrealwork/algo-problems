package com.leetcode.ds.trie;

import java.util.Deque;
import java.util.LinkedList;

class ShortEncodingOfWords {
    private ShortEncodingOfWords() {
    }

    public int minimumLengthEncoding(String[] words) {
        SuffixTrie suffixTrie = trie(words);
        Deque<SuffixTrie.TrieNode> trieNode = new LinkedList<>();
        trieNode.add(suffixTrie.root);
        int res = 0;
        while (!trieNode.isEmpty()) {
            SuffixTrie.TrieNode node = trieNode.removeLast();
            if (node.isTerminal() && node.size == 0) {
                res += (words[node.wordIndex].length() + 1);
            } else {
                for (int i = 0; i < node.nodes.length; i++) {
                    SuffixTrie.TrieNode nextNode = node.nodes[i];
                    if (nextNode != null) {
                        trieNode.addFirst(nextNode);
                    }
                }
            }
        }
        return res;
    }

    private static SuffixTrie trie(String... words) {
        SuffixTrie trie = new SuffixTrie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words, i);
        }
        return trie;
    }

    static class SuffixTrie {
        private final TrieNode root;

        public SuffixTrie() {
            root = new TrieNode();
        }

        public void insert(String[] words, int index) {
            String word = words[index];
            if (word.isEmpty()) {
                return;
            }
            TrieNode parent = root;
            for (int i = word.length() - 1; i >= 0; i--) {
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

        private static class TrieNode {
            private final TrieNode[] nodes;
            private int size = 0;

            public void setWordIndex(int wordIndex) {
                this.wordIndex = wordIndex;
            }

            private int wordIndex = -1;

            private TrieNode() {
                this.nodes = new TrieNode['z' - 'a' + 1];
            }


            void addChild(char c, TrieNode node) {
                if (nodes[c - 'a'] == null) {
                    size++;
                }
                nodes[c - 'a'] = node;

            }

            TrieNode getChild(char c) {
                return nodes[c - 'a'];
            }

            boolean isTerminal() {
                return wordIndex > -1;
            }

        }
    }
}
