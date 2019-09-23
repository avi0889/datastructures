package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class Node {
        Map<Character, Node> children;
        boolean isLeaf;

        public Node() {
            children = new HashMap<>();
            isLeaf = false;
        }
    }

    private Node root;

    public Trie() {
        root = null;
    }

    public void insert(String word) {
        if(root == null) {
            root = new Node();
        }
        insertInternal(root, word, 0);
    }

    private void insertInternal(Node node, String word, int index) {
        if(index == word.length()) {
            node.isLeaf = true;
            return;
        }
        Character character = word.charAt(index);
        Node child = node.children.get(character);
        if(child == null)
            child = new Node();
        node.children.put(character, child);
        insertInternal(child, word, index + 1);
    }

    public boolean search(String word) {
        if(root == null)
            return false;
        return searchInternal(root, word, 0);
    }

    private boolean searchInternal(Node node, String word, int index) {
        if(index == word.length()) {
            return node.isLeaf;
        }
        Character character = word.charAt(index);
        Node child = node.children.get(character);
        if(child != null)
            return searchInternal(child, word, index + 1);
        return false;
    }
}
