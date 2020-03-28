package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-28
 */
class ShortEncodingOfWordsTest extends AbstractTest<ShortEncodingOfWords> {
    @Override
    protected Testsuite<ShortEncodingOfWords> testsuite() {
        return Testsuite.<ShortEncodingOfWords>builder()
                .add(ExpectedTestcase.of(4, t -> t.minimumLengthEncoding(new String[]{"a", "b"})))
                .add(ExpectedTestcase.of(8, t -> t.minimumLengthEncoding(new String[]{"a", "bc", "dc"})))
                .add(ExpectedTestcase.of(10, t -> t.minimumLengthEncoding(new String[]{"time", "me", "bell"})))
                .add(ExpectedTestcase.of(14, t -> t.minimumLengthEncoding(new String[]{"times", "me", "bell"})))
                .add(ExpectedTestcase.of(8, t -> t.minimumLengthEncoding(new String[]{"abcdefg", "defg", "fg"})))
                .add(ExpectedTestcase.of(12, t -> t.minimumLengthEncoding(new String[]{"time", "atime", "btime"})))
                .build();
    }
}