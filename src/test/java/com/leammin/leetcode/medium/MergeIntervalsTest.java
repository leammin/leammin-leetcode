package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-01
 */
class MergeIntervalsTest extends AbstractTest<MergeIntervals> {
    @Override
    protected Testsuite<MergeIntervals> testsuite() {
        return Testsuite.<MergeIntervals>builder()
                .add(ExpectedTestcase.of(new int[][]{{1,6},{8,10},{15,18}}, t->t.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})))
                .add(ExpectedTestcase.of(new int[][]{{1,5}}, t->t.merge(new int[][]{{1,4},{4,5}})))
                .build();
    }
}