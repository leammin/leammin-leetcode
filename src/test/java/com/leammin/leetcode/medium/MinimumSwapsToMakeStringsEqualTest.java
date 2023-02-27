package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-25
 */
class MinimumSwapsToMakeStringsEqualTest extends AbstractTest<MinimumSwapsToMakeStringsEqual> {
    @Override
    protected Testsuite<MinimumSwapsToMakeStringsEqual> testsuite() {
        return Testsuite.<MinimumSwapsToMakeStringsEqual>builder()
                .addExpected(t -> t.minimumSwap("xx", "yy"), 1)
                .addExpected(t -> t.minimumSwap("xy", "yx"), 2)
                .addExpected(t -> t.minimumSwap("xx", "yx"), -1)
                .addExpected(t -> t.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"), 4)
                .build();
    }
}