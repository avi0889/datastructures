package com.ds.tree;

import java.util.Random;

/**
 * Ref: http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/skip-list-impl.html
 * @param <T>
 */
public class SkipList<T extends Comparable<T>> {

    private class Node {
        T value;
        boolean isStartPoint;
        boolean isEndPoint;
        Node up, down, left, right;

        public Node() {}

        public Node(T val) {
            this.value = val;
        }
    }

    private Node head, tail;
    private int size, height;
    private Random random;

    public SkipList() {
        head = new Node(null);
        head.isStartPoint = true;
        tail = new Node(null);
        tail.isEndPoint = true;
        head.right = tail;
        tail.left = head;
        height = 0;
        size = 0;
        random = new Random();
    }

    /**
     * Returns whether or not this collection is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }

    /**
     * Returns the size of this collection
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns true of false based on the presence of given value in this collection
     */
    public boolean isPresent(T value) {
        Node node = search(value);
        return node != null && !node.isStartPoint && !node.isEndPoint && node.value.equals(value);
    }

    public void insert(T value) {
        Node node = search(value);
        if(node.isStartPoint || node.isEndPoint || !node.value.equals(value)) {
            Node newNode = new Node(value);
            newNode.left = node;
            newNode.right = node.right;
            node.right.left = newNode;
            node.right = newNode;

            //insert in upper levels
            int i = 0;
            while(random.nextFloat() < 0.5) {   //our way of saying, until heads is the outcome
                if(i >= height) {
                    //reached top layer, need to create new level here
                    insertNewLevel();
                }
                while(node.up == null) {
                    node = node.left;
                }
                node = node.up;
                Node n = new Node(value);
                //assignments
                n.down = newNode;
                newNode.up = n;
                n.left = node;
                n.right = node.right;
                node.right.left = n;
                node.right = n;

                //prep for next iteration
                newNode = n;
                i++;
            }
            size++;
        }
    }

    /**
     * insert a new level
     */
    private void insertNewLevel() {
        height++;

        Node node1 = new Node(null);
        node1.isStartPoint = true;

        Node node2 = new Node(null);
        node2.isEndPoint = true;

        node1.right = node2;
        node2.left = node1;

        node1.down  = head;
        node2.down = tail;
        head.up = node1;
        tail.up = node2;

        head = node1;
        tail = node2;
    }

    /**
     * finds the node that is either equal to given node or the closest lesser one, in the bottom most level,
     * so that we can use it for insertion as well
     * @param value
     * @return
     */
    private Node search(T value) {
        Node node = head;
        while(true) {
            while(!node.right.isEndPoint && node.right.value.compareTo(value) <= 0) {
                node = node.right;
            }
            if(node.down != null)
                node = node.down;
            else
                break;
        }
        return node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while(node != null) {
            Node thisLevelHead = node;
            node = node.right;  //skip the head of this level
            while(!node.isEndPoint) {
                sb.append(node.value);
                sb.append("  ");
                node = node.right;
            }
            sb.append("\n");
            node = thisLevelHead.down;
        }
        return sb.toString();
    }
}
