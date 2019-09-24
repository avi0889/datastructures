package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> elements;

    public MinHeap() {
        elements = new ArrayList<>();
    }

    public void insert(T val) {
        if(elements.isEmpty()) {
            elements.add(val);
            return;
        }
        elements.add(val);
        propagateUp(elements.size() - 1, parentIndex(elements.size() - 1));
    }

    private void propagateUp(int childIndex, int parentIndex) {
        if(elements.get(childIndex).compareTo(elements.get(parentIndex)) < 0) {
            swap(childIndex, parentIndex);
            propagateUp(parentIndex, parentIndex(parentIndex));
        }
    }

    public T peekLeastElement() {
        return elements.get(0);
    }

    public T popLeastElement() {
        T returnVal = elements.get(0);

        //place last element to first position
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);

        //heapify the list
        minHeapify(0);

        return returnVal;
    }

    private void minHeapify(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        if(leftChildIndex < elements.size()) {
            if(rightChildIndex < elements.size()) {
                if(elements.get(leftChildIndex).compareTo(elements.get(rightChildIndex)) < 0) {
                    if(elements.get(index).compareTo(elements.get(leftChildIndex)) > 0) {
                        swap(leftChildIndex, index);
                    }
                } else {
                    if(elements.get(index).compareTo(elements.get(rightChildIndex)) > 0) {
                        swap(rightChildIndex, index);
                    }
                }
            } else {
                if(elements.get(index).compareTo(elements.get(leftChildIndex)) > 0) {
                    swap(leftChildIndex, index);
                    minHeapify(leftChildIndex);
                }
            }
        }
    }

    private void swap(int childIndex, int parentIndex) {
        T tempVal = elements.get(childIndex);
        elements.set(childIndex, elements.get(parentIndex));
        elements.set(parentIndex, tempVal);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }
}
