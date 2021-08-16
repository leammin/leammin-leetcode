package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-09
 */
class ImplementTriePrefixTreeTest extends AbstractTest<ImplementTriePrefixTree> {
    @Override
    protected Testsuite<ImplementTriePrefixTree> testsuite() {
        return Testsuite.<ImplementTriePrefixTree>builder()
                .addExpected(t -> {
//                    trie.insert("apple");
//                    trie.search("apple");   // 返回 true
//                    trie.search("app");     // 返回 false
//                    trie.startsWith("app"); // 返回 true
//                    trie.insert("app");
//                    trie.search("app");     // 返回 true
                    boolean[] res = new boolean[4];
                    t.insert("apple");
                    res[0] = t.search("apple");
                    res[1] = t.search("app");
                    res[2] = t.startsWith("app");
                    t.insert("app");
                    res[3] = t.search("app");
                    return res;
                }, new boolean[]{true, false, true, true})
                .build();
    }
}