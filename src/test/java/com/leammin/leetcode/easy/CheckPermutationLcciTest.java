package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-27
 */
class CheckPermutationLcciTest extends AbstractTest<CheckPermutationLcci> {
    @Override
    protected Testsuite<CheckPermutationLcci> testsuite() {
        return Testsuite.<CheckPermutationLcci>builder()
                .addExpected(t -> t.CheckPermutation("abc", "cba"), true)
                .build();
    }
}