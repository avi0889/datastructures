package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * If the height imbalance is due to:
 * 1. left child's left child addition, LL rotation
 * 2. right child's right child addition, RR rotation
 * 3. left child's right child addition, LR rotation
 * 4. right child's left child addition, RL rotation
 *
 */
public class AVL<T extends Comparable<T>> {

    private class Node {
        T val;
        int height;
        Node leftChild;
        Node rightChild;

        public Node(T val) {
            this.val = val;
        }
    }

    private Node root;

    public AVL() {
        root = null;
    }

    public int height() {
        return root.height;
    }

    private int height(Node node) {
        if(node == null)
            return -1;
        return node.height;
    }

    private int balance(Node node) {
        if(node == null)
            return 0;
        return height(node.leftChild) - height(node.rightChild);
    }

    public void insert(T val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        root = insertInternal(root, val);
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

        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;

        node = balanceNode(node);
        return node;
    }

    private Node balanceNode(Node node) {
        if(balance(node) > 1) {
            if(balance(node.leftChild) < 0)
                node.leftChild = leftRotate(node.leftChild);
            node = rightRotate(node);
        } else if(balance(node) < -1) {
            if(balance(node.rightChild) > 0)
                node.rightChild = rightRotate(node.rightChild);
            node = leftRotate(node);
        }
        return node;
    }

    /**
     *     A              B
     *   B      ==>     C   A
     * C
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node temp = node.leftChild;
        node.leftChild = temp.rightChild;
        temp.rightChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        temp.height = Math.max(height(temp.leftChild), height(temp.rightChild)) + 1;
        return temp;
    }

    /**
     *     A              B
     *       B     ==>  A   C
     *         C
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node temp = node.rightChild;
        node.rightChild = temp.leftChild;
        temp.leftChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        temp.height = Math.max(height(temp.leftChild), height(temp.rightChild)) + 1;
        return temp;
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
}
