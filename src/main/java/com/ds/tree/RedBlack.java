package com.ds.tree;

/**
 * Properties
 * 1. root is always black
 * 2. Each leaf node(NULL node) is black
 * 3. Children of a red node are black
 * 4. Every path from a given node to any of its descendant NIL nodes contains the same number of black nodes.
 *
 * Rules
 * 1. If black aunt, rotate
 * 2. If red aunt, color flip
 */
public class RedBlack {

    enum Color {
        BLACK, RED;
    }

    private class Node {
        int val;
        int height;
        Node leftChild;
        Node rightChild;
        Node parent;
        Color color;

        public Node(int val, Color color) {
            this.val = val;
            this.color = color;
            leftChild = rightChild = parent = null;
        }

        public Node getParent() {
            return parent;
        }
    }

    private Node root;

    public void insert(int val) {
        if (root == null) {
            root = new Node(val, Color.BLACK);
            return;
        }
        root = insertInternal(root, root.parent, true, val);
    }

    private Node insertInternal(Node node, Node parent, boolean isLeftChild, int val) {
        if(node == null) {
            node = new Node(val, Color.RED);
            node.parent = parent;
            if(isLeftChild && parent != null)
                parent.leftChild = node;
            else if(parent != null)
                parent.rightChild = node;
        } else if (val == node.val) {
            node.val = val;
            return node;
        } else if (val < node.val) {
            node.leftChild = insertInternal(node.leftChild, node, true, val);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insertInternal(node.rightChild, node, false, val);
            node.rightChild.parent = node;
        }
        node = adjustAfterInsertion(node);
        return node;
    }

    private Node adjustAfterInsertion(Node node) {
        // Step 1: Correct double red problems, if they exist
        if (node != null && node != root && isRed(parentOf(node))) {
            if (isRed(siblingOf(parentOf(node)))) {
                // Step 1a (simplest): Recolor, and move up to see if more work needed

                setColor(parentOf(node), Color.BLACK);
                setColor(siblingOf(parentOf(node)), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);
                node = adjustAfterInsertion(grandparentOf(node));
            } else if (parentOf(node) == leftOf(grandparentOf(node))) {
                // Step 1b: Restructure for a parent who is the left child of the
                // grandparent. This will require a single right rotation if n is
                // also a left child, or a left-right rotation otherwise.

                if (node == rightOf(parentOf(node))) {
                    node = parentOf(node);
                    leftRotate(node);
                }
                setColor(parentOf(node), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);
                node = rightRotate(grandparentOf(node));
            } else if (parentOf(node) == rightOf(grandparentOf(node))) {
                // Step 1c: Restructure for a parent who is the right child of the
                // grandparent. This will require a single left rotation if n is
                // also a right child, or a right-left rotation otherwise.

                if (node == leftOf(parentOf(node))) {
                    rightRotate(node = parentOf(node));
                }
                setColor(parentOf(node), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);
                node = leftRotate(grandparentOf(node));
            }
        }
        // Step 2: Color the root black
        setColor(root, Color.BLACK);
        return node;
    }

    private Node rightRotate(Node node) {
        //perform rotation
        Node temp = node.leftChild;
        node.leftChild = temp.rightChild;
        temp.rightChild = node;

        //set the new parent
        temp.parent = node.parent;
        node.parent = temp;
        if(node.leftChild != null)
            node.leftChild.parent = node;

        //set the new heights
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        temp.height = Math.max(height(temp.leftChild), height(temp.rightChild)) + 1;
        return temp;
    }

    private Node leftRotate(Node node) {
        //perform rotation
        Node temp = node.rightChild;
        node.rightChild = temp.leftChild;
        temp.leftChild = node;

        //set the new parent
        temp.parent = node.parent;
        node.parent = temp;
        if(node.rightChild != null)
            node.rightChild.parent = node;

        //set the new heights
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        temp.height = Math.max(height(temp.leftChild), height(temp.rightChild)) + 1;
        return temp;
    }

    private int height(Node node) {
        if(node == null)
            return -1;
        return node.height;
    }

    private Color colorOf(Node node) {
        return node == null ? Color.BLACK : node.color;
    }

    private boolean isRed(Node node) {
        return node != null && colorOf(node) == Color.RED;
    }

    private boolean isBlack(Node node) {
        return node == null || colorOf(node) == Color.BLACK;
    }

    private void setColor(Node node, Color color) {
        if (node != null)
            node.color = color;
    }

    private Node parentOf(Node node) {
        return node == null ? null : (Node) node.getParent();
    }

    private Node grandparentOf(Node node) {
        return (node == null || node.getParent() == null) ? null : (Node) node.getParent().getParent();
    }

    private Node siblingOf(Node node) {
        return (node == null || node.getParent() == null) ? null : (node == node.getParent().leftChild)
                ? (Node) node.getParent().rightChild : (Node) node.getParent().leftChild;
    }

    private Node leftOf(Node node) {
        return node == null ? null : node.leftChild;
    }

    private Node rightOf(Node node) {
        return node == null ? null : node.rightChild;
    }
}
