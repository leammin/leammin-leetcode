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
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"a", "b"}), 4))
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"a", "bc", "dc"}), 8))
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"time", "me", "bell"}), 10))
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"times", "me", "bell"}), 14))
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"abcdefg", "defg", "fg"}), 8))
                .add(ExpectedTestcase.of(t -> t.minimumLengthEncoding(new String[]{"time", "atime", "btime"}), 12))
                .build();
    }
}