package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> {

    private class Node {
        T val;
        Node leftChild;
        Node rightChild;

        public Node(T val) {
            this.val = val;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(T val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        insertInternal(root, val);
    }

    private Node insertInternal(Node node, T val) {
        if(node == null) {
            node = new Node(val);
            return node;
        }
        if(val.compareTo(node.val) <= 0) {
            node.leftChild = insertInternal(node.leftChild, val);
        } else {
            node.rightChild = insertInternal(node.rightChild, val);
        }
        return node;
    }

    public boolean search(T val) {
        Node node = searchInternal(root, val);
        if(node == null)
            return false;
        return true;
    }

    private Node searchInternal(Node node, T val) {
        if(node == null)
            return null;
        if(node.val.compareTo(val) == 0)
            return node;
        if(val.compareTo(node.val) < 0)
            return searchInternal(node.leftChild, val);
        else
            return searchInternal(node.rightChild, val);
    }

    public int height() {
        return heightInternal(root);
    }

    private int heightInternal(Node node) {
        if(node == null)
            return -1;
        return Math.max(heightInternal(node.leftChild), heightInternal(node.rightChild)) + 1;
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversalInternal(root, list);
        return list;
    }

    private void inOrderTraversalInternal(Node node, List<T> list) {
        if(node == null)
            return;
        inOrderTraversalInternal(node.leftChild, list);
        list.add(node.val);
        inOrderTraversalInternal(node.rightChild, list);
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        preOrderTraversalInternal(root, list);
        return list;
    }

    private void preOrderTraversalInternal(Node node, List<T> list) {
        if(node == null)
            return;
        list.add(node.val);
        preOrderTraversalInternal(node.leftChild, list);
        preOrderTraversalInternal(node.rightChild, list);
    }

    public List<T> postOrderTraversal() {
        List<T> list = new ArrayList<>();
        postOrderTraversalInternal(root, list);
        return list;
    }

    private void postOrderTraversalInternal(Node node, List<T> list) {
        if(node == null)
            return;
        postOrderTraversalInternal(node.leftChild, list);
        postOrderTraversalInternal(node.rightChild, list);
        list.add(node.val);
    }
}