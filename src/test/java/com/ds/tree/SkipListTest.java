package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class SkipListTest {
    @Test
    public void testInsert() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(12);
        list.insert(17);
        list.insert(20);
        list.insert(25);
        list.insert(31);
        list.insert(38);
        list.insert(39);
        list.insert(44);
        list.insert(50);
        list.insert(55);
        Assert.assertNotNull(list);
    }

    @Test
    public void testSearch() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(12);
        list.insert(17);
        list.insert(20);
        list.insert(25);
        list.insert(31);
        list.insert(38);
        list.insert(39);
        list.insert(44);
        list.insert(50);
        list.insert(55);
        Assert.assertTrue(list.isPresent(17));
    }

    @Test
    public void testIsEmpty() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(12);
        list.insert(17);
        list.insert(20);
        list.insert(25);
        list.insert(31);
        list.insert(38);
        list.insert(39);
        list.insert(44);
        list.insert(50);
        list.insert(55);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(12);
        list.insert(17);
        list.insert(20);
        list.insert(25);
        list.insert(31);
        list.insert(38);
        list.insert(39);
        list.insert(44);
        list.insert(50);
        list.insert(55);
        Assert.assertEquals(list.size(), 10);
    }

    @Test
    public void testToString() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(12);
        list.insert(17);
        list.insert(20);
        list.insert(25);
        list.insert(31);
        list.insert(38);
        list.insert(39);
        list.insert(44);
        list.insert(50);
        list.insert(55);
        System.out.println(list.toString());
        Assert.assertNotNull(list.toString());
    }
}
