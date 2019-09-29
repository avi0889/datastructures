package com.ds.tree;

/**
 * For range sum queries
 * * The leaf nodes hold the array elements
 * * REMEMBER while navigating the tree, half of the leaf nodes will be on left of root and rest on right
 * Three cases when looking for index i to j:
 * 1. partial overlap: if (i,j) partially overlaps current segment tree interval, look into both children
 * 2. total overlap: if (i,j) totally overlaps tree's current node interval, STOP and return this node's value
 * 3. no overlap: if (i,j) does not overlap tree's current node interval, return MAX
 */
public class SegmentTreeRangeSum {

    private int[] tree;
    private int numberOfElements;

    public SegmentTreeRangeSum(int[] arr) {
        numberOfElements = arr.length;
        if(arr.length > 0) {
            int treeSize = (nextPowerOfTwo(arr.length) * 2) - 1;
            tree = new int[treeSize];
            init(arr, 0, 0, arr.length - 1);
        } else {
            tree = new int[0];
        }
    }

    private int init(int[] arr, int parentIndex, int leftChildIndex, int rightChildIndex) {
        if(leftChildIndex == rightChildIndex) {   //leaf node, put the array element here
            tree[parentIndex] = arr[leftChildIndex];
            return tree[parentIndex];
        }
        int leftVal = init(arr, (parentIndex * 2) + 1, leftChildIndex, (leftChildIndex + rightChildIndex) / 2);
        int rightVal = init(arr, (parentIndex * 2) + 2, ((leftChildIndex + rightChildIndex) / 2) + 1, rightChildIndex);
        tree[parentIndex] = leftVal + rightVal;
        return tree[parentIndex];
    }

    public int getRangeSum(int fromIndex, int toIndex) {
        return rangeSum(0, 0, numberOfElements - 1, fromIndex, toIndex);
    }

    private int rangeSum(int treeIndex, int leftIndex, int rightIndex, int queryFromIndex, int queryToIndex) {
        if(queryFromIndex > rightIndex || queryToIndex < leftIndex) //no overlap
            return 0;
        if(queryFromIndex <= leftIndex && queryToIndex >= rightIndex) //total overlap
            return tree[treeIndex];
        //partial overlap
        int leftVal = rangeSum((treeIndex * 2) + 1, leftIndex, (leftIndex + rightIndex) / 2, queryFromIndex, queryToIndex);
        int rightVal = rangeSum((treeIndex * 2) + 2, ((leftIndex + rightIndex) / 2) + 1, rightIndex, queryFromIndex, queryToIndex);
        return leftVal + rightVal;
    }

    public void update(int index, int val) {
        updateTree(0, 0, numberOfElements - 1, val, index);
    }

    private int updateTree(int treeIndex, int leftIndex, int rightIndex, int val, int index) {
        int delta = 0;
        if(leftIndex == rightIndex) {
            delta = val - tree[treeIndex];
            tree[treeIndex] = val;
            return delta;
        }
        int mid = (leftIndex + rightIndex) / 2;
        if(index <= mid) {
            delta = updateTree((treeIndex * 2) + 1, leftIndex, mid, val, index);
            tree[treeIndex] += delta;
        } else {
            delta = updateTree((treeIndex * 2) + 2, mid + 1, rightIndex, val, index);
            tree[treeIndex] += delta;
        }
        return delta;
    }

    /**
     * returns same number if num is a power of 2, else the next power of 2 greater than num
     * @param num
     * @return
     */
    private int nextPowerOfTwo(int num) {
        if(num == 0)
            return 1;
        if((num & (num - 1)) == 0)
            return num;
        while((num & (num - 1)) > 0) {
            num &= num - 1;
        }
        return num << 1;
    }

    public int treeSize() {
        return tree.length;
    }
}
