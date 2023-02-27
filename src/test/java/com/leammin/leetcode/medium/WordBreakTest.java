package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-06-25
 */
class WordBreakTest extends AbstractTest<WordBreak> {
    @Override
    protected Testsuite<WordBreak> testsuite() {
        return Testsuite.<WordBreak>builder()
                .add(ExpectedTestcase.of(t -> t.wordBreak("leetcode", List.of("leet", "code")), true))
                .add(ExpectedTestcase.of(t -> t.wordBreak("applepenapple", List.of("apple", "pen")), true))
                .add(ExpectedTestcase.of(t -> t.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")), false))
                .add(ExpectedTestcase.of(t -> t.wordBreak("bb", List.of("a","b","bbb","bbbb")), true))
                .build();
    }
}