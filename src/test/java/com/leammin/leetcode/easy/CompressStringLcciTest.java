package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-16
 */
class CompressStringLcciTest extends AbstractTest<CompressStringLcci> {
    @Override
    protected Testsuite<CompressStringLcci> testsuite() {
        return Testsuite.<CompressStringLcci>builder()
                .add(ExpectedTestcase.of("a2b1c5a3", t -> t.compressString("aabcccccaaa")))
                .add(ExpectedTestcase.of("abbccd", t -> t.compressString("abbccd")))
                .build();
    }
}