package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class AVLTest {
    @Test
    public void testInsert() {
        AVL<Integer> tree = new AVL<>();
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(6);
        Assert.assertEquals(tree.search(5), true);
    }

    @Test
    public void testSearchWhenPresent() {
        AVL tree  = new AVL();
        tree.insert(5);
        Assert.assertEquals(tree.search(5), true);
    }

    @Test
    public void testSearchWhenNotPresent() {
        AVL tree  = new AVL();
        tree.insert(5);
        Assert.assertEquals(tree.search(4), false);
    }

    /**
     *      6
     *   5    6
     * 3  6    7
     *
     */
    @Test
    public void testHeight() {
        AVL tree  = new AVL();
        tree.insert(5);
        Assert.assertEquals(tree.height(), 0);
        tree.insert(3);
        Assert.assertEquals(tree.height(), 1);
        tree.insert(7);
        Assert.assertEquals(tree.height(), 1);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 2);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 2);
        tree.insert(6);
        Assert.assertEquals(tree.height(), 2);
    }

    @Test
    public void testInOrderTraversalString() {
        AVL<String> tree  = new AVL<>();
        tree.insert("ab");
        tree.insert("aab");
        tree.insert("cd");
        tree.insert("rf");
        tree.insert("fr");
        tree.insert("fg");
        tree.insert("ew");
        Assert.assertThat(tree.inOrderTraversal(), is(new ArrayList<>(Arrays.asList("aab", "ab", "cd", "ew", "fg", "fr", "rf"))));
    }
}
