package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-19
 */
class StrongPasswordCheckerIiTest extends AbstractTest<StrongPasswordCheckerIi> {
    @Override
    protected Testsuite<StrongPasswordCheckerIi> testsuite() {
        return Testsuite.<StrongPasswordCheckerIi>builder()
                .addExpected(t -> t.strongPasswordCheckerII("IloveLe3tcode!"), true)
                .addExpected(t -> t.strongPasswordCheckerII("Me+You--IsMyDream"), false)
                .addExpected(t -> t.strongPasswordCheckerII("1aB!"), false)
                .build();
    }
}