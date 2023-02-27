package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class IsomorphicStringsTest extends AbstractTest<IsomorphicStrings> {
    @Override
    protected Testsuite<IsomorphicStrings> testsuite() {
        return Testsuite.<IsomorphicStrings>builder()
                .add(ExpectedTestcase.of(t -> t.isIsomorphic("egg", "add"), true))
                .add(ExpectedTestcase.of(t -> t.isIsomorphic("foo", "bar"), false))
                .add(ExpectedTestcase.of(t -> t.isIsomorphic("paper", "title"), true))
                .add(ExpectedTestcase.of(t -> t.isIsomorphic("ab", "aa"), false))
                .add(ExpectedTestcase.of(t -> t.isIsomorphic("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./", "qwertyuiop[]asdfghjkl;'\\zxcvbnm,./"), true))
                .build();
    }
}