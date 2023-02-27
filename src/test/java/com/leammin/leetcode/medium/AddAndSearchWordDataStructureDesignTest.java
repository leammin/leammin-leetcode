package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-09
 */
class AddAndSearchWordDataStructureDesignTest extends AbstractTest<AddAndSearchWordDataStructureDesign> {
    @Override
    protected Testsuite<AddAndSearchWordDataStructureDesign> testsuite() {
        return Testsuite.<AddAndSearchWordDataStructureDesign>builder()
                .addExpected(t -> {
                    t.addWord("bad");
                    t.addWord("dad");
                    t.addWord("mad");
                    return new boolean[]{
                            t.search("pad"),
                            t.search("bad"),
                            t.search(".ad"),
                            t.search("b..")
                    };
                }, new boolean[]{
                        false,
                        true,
                        true,
                        true
                })
                .addExpected(t -> {
//                    ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
//                    [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
                    t.addWord("a");
                    t.addWord("a");
                    return new boolean[]{
                            t.search("."),
                            t.search("a"),
                            t.search("aa"),
                            t.search("a"),
                            t.search(".a"),
                            t.search("a."),
                    };
                }, new boolean[]{
                        true,
                        true,
                        false,
                        true,
                        false,
                        false,
                })
                .build();
    }
}