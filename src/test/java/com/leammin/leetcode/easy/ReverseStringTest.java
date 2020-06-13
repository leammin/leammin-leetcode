package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-13
 */
class ReverseStringTest extends AbstractTest<ReverseString> {
    @Override
    protected Testsuite<ReverseString> testsuite() {
        return Testsuite.<ReverseString>builder()
                .add(ExpectedTestcase.of(t -> {
                    char[] c = "hello".toCharArray();
                    t.reverseString(c);
                    return c;
                }, "olleh".toCharArray()))
                .build();
    }
}