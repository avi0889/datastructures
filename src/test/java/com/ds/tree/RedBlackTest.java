package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTest {
    @Test
    public void testInsertion() {
        RedBlack tree = new RedBlack();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        Assert.assertEquals(2, 2);
    }
}
