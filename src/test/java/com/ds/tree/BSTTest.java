package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class BSTTest {

    @Test
    public void testInsertion() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        Assert.assertEquals(tree.search(5), true);
    }

    @Test
    public void testHeight() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        Assert.assertEquals(tree.height(), 0);
        tree.insert(3);
        Assert.assertEquals(tree.height(), 1);
        tree.insert(7);
        Assert.assertEquals(tree.height(), 1);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 2);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 3);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 4);
    }

    @Test
    public void testSearchWhenPresent() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        Assert.assertEquals(tree.search(5), true);
    }

    @Test
    public void testSearchWhenNotPresent() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        Assert.assertEquals(tree.search(4), false);
    }

    /**
     *          5
     *       3     7
     *     2  4  6  8
     */
    @Test
    public void testInOrderTraversal() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(4);
        Assert.assertThat(tree.inOrderTraversal(), is(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8))));
    }

    @Test
    public void testPreOrderTraversal() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(4);
        Assert.assertThat(tree.preOrderTraversal(), is(new ArrayList<>(Arrays.asList(5, 3, 2, 4, 7, 6, 8))));
    }

    @Test
    public void testPostOrderTraversal() {
        BST<Integer> tree  = new BST<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(4);
        Assert.assertThat(tree.postOrderTraversal(), is(new ArrayList<>(Arrays.asList(2, 4, 3, 6, 8, 7, 5))));
    }
}
