package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-09
 */
class ReplaceWordsTest extends AbstractTest<ReplaceWords> {
    @Override
    protected Testsuite<ReplaceWords> testsuite() {
        return Testsuite.<ReplaceWords>builder()
                .addExpected(t -> t.replaceWords(List.of("cat", "bat", "rat"),
                        "the cattle was rattled by the battery"),
                        "the cat was rat by the bat")
                .build();
    }
}