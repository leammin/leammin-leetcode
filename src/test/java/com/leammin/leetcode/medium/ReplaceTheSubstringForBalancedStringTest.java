package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-14
 */
class ReplaceTheSubstringForBalancedStringTest extends AbstractTest<ReplaceTheSubstringForBalancedString> {
    @Override
    protected Testsuite<ReplaceTheSubstringForBalancedString> testsuite() {
        return Testsuite.<ReplaceTheSubstringForBalancedString>builder()
                .addExpected(t -> t.balancedString("QWER"), 0)
                .addExpected(t -> t.balancedString("QQWE"), 1)
                .addExpected(t -> t.balancedString("QQQW"), 2)
                .addExpected(t -> t.balancedString("QQQQ"), 3)
                .build();
    }
}