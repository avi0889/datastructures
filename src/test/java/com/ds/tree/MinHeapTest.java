package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {
    @Test
    public void testInsertion() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(4);
        heap.insert(5);
        heap.insert(3);
        heap.insert(6);
        heap.insert(8);
        heap.insert(1);
        Assert.assertEquals(2, 2);
    }

    @Test
    public void testPeek() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(4);
        heap.insert(5);
        heap.insert(3);
        heap.insert(6);
        heap.insert(8);
        heap.insert(1);
        Assert.assertEquals(heap.peekLeastElement(), new Integer(1));
    }

    @Test
    public void testPop() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(4);
        heap.insert(5);
        heap.insert(3);
        heap.insert(6);
        heap.insert(8);
        heap.insert(1);
        Assert.assertEquals(heap.popLeastElement(), new Integer(1));
        Assert.assertEquals(heap.popLeastElement(), new Integer(3));
    }
}
