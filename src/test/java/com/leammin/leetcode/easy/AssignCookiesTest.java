package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class AssignCookiesTest extends AbstractTest<AssignCookies> {
    @Override
    protected Testsuite<AssignCookies> testsuite() {
        return Testsuite.<AssignCookies>builder()
                .add(ExpectedTestcase.of(t -> t.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}), 1))
                .add(ExpectedTestcase.of(t -> t.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}), 2))
                .build();
    }
}