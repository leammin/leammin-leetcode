package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-06
 */
class ImplementStrstrTest extends AbstractTest<ImplementStrstr> {
    @Override
    protected Testsuite<ImplementStrstr> testsuite() {
        return Testsuite.<ImplementStrstr>builder()
                .add(ExpectedTestcase.of(t -> t.strStr("hello",  "ll"), 2))
                .add(ExpectedTestcase.of(t -> t.strStr("aaaaa",  "bba"), -1))
                .add(ExpectedTestcase.of(t -> t.strStr("a",  "a"), 0))
                .build();
    }
}