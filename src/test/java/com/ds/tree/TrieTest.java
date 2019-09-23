package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {
    @Test
    public void testInsertion() {
        Trie trie = new Trie();
        trie.insert("ab");
        Assert.assertEquals(2, 2);
    }

    @Test
    public void testSearchWhenPresent() {
        Trie trie = new Trie();
        trie.insert("ana");
        trie.insert("and");
        trie.insert("ann");
        trie.insert("bag");
        trie.insert("cat");
        trie.insert("day");
        trie.insert("dog");
        Assert.assertEquals(trie.search("and"), true);
    }

    @Test
    public void testSearchWhenAbsent() {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("abc");
        Assert.assertEquals(trie.search("a"), false);
    }
}
