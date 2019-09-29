package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeRangeSumTest {

    @Test
    public void testBuildTree() {
        int arr[] = {0,3,4,2,1,6,-1};
        SegmentTreeRangeSum tree = new SegmentTreeRangeSum(arr);
        Assert.assertEquals(tree.treeSize(), 15);
    }

    @Test
    public void testRangeSum() {
        int arr[] = {0,3,4,2,1,6,-1};
        SegmentTreeRangeSum tree = new SegmentTreeRangeSum(arr);
        Assert.assertEquals(tree.getRangeSum(0, 3), 9);
        Assert.assertEquals(tree.getRangeSum(1, 2), 7);
        Assert.assertEquals(tree.getRangeSum(1, 4), 10);
        Assert.assertEquals(tree.getRangeSum(2, 6), 12);
        Assert.assertEquals(tree.getRangeSum(0, 6), 15);
    }

    @Test
    public void testUpdate() {
        int arr[] = {0,3,4,2,1,6,-1};
        SegmentTreeRangeSum tree = new SegmentTreeRangeSum(arr);
        tree.update(0, 1);
        Assert.assertEquals(tree.getRangeSum(0, 3), 10);
        tree.update(3, 1);
        Assert.assertEquals(tree.getRangeSum(0, 3), 9);
    }

    @Test
    public void testRangeSumOverAllRanges() {
        int arr[] = {1,5,2,4,3};
        SegmentTreeRangeSum tree = new SegmentTreeRangeSum(arr);
        Assert.assertEquals(tree.getRangeSum(0, 0), 1);
        Assert.assertEquals(tree.getRangeSum(1, 1), 5);
        Assert.assertEquals(tree.getRangeSum(2, 2), 2);
        Assert.assertEquals(tree.getRangeSum(3, 3), 4);
        Assert.assertEquals(tree.getRangeSum(4, 4), 3);

        Assert.assertEquals(tree.getRangeSum(0, 1), 6);
        Assert.assertEquals(tree.getRangeSum(1, 2), 7);
        Assert.assertEquals(tree.getRangeSum(2, 3), 6);
        Assert.assertEquals(tree.getRangeSum(3, 4), 7);

        Assert.assertEquals(tree.getRangeSum(0, 2), 8);
        Assert.assertEquals(tree.getRangeSum(1, 3), 11);
        Assert.assertEquals(tree.getRangeSum(2, 4), 9);

        Assert.assertEquals(tree.getRangeSum(0, 3), 12);
        Assert.assertEquals(tree.getRangeSum(1, 4), 14);

        Assert.assertEquals(tree.getRangeSum(0, 4), 15);
    }

    @Test
    public void testEmptyInput() {
        int arr[] = {};
        SegmentTreeRangeSum tree = new SegmentTreeRangeSum(arr);
        Assert.assertEquals(tree.treeSize(), 0);
    }
}
