package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.CheckArrayFormationThroughConcatenation;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-22
 */
class CheckArrayFormationThroughConcatenationTest extends AbstractTest<CheckArrayFormationThroughConcatenation> {
    @Override
    protected Testsuite<CheckArrayFormationThroughConcatenation> testsuite() {
        return Testsuite.<CheckArrayFormationThroughConcatenation>builder()
                .addExpected(t -> t.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}), true)
                .addExpected(t -> t.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}), false)
                .addExpected(t -> t.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}), true)
                .build();
    }
}