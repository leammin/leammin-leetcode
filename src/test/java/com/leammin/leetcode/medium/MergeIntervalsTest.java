package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-01
 */
class MergeIntervalsTest extends AbstractTest<MergeIntervals> {
    @Override
    protected Testsuite<MergeIntervals> testsuite() {
        return Testsuite.<MergeIntervals>builder()
                .add(ExpectedTestcase.of(t->t.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}), new int[][]{{1,6},{8,10},{15,18}}))
                .add(ExpectedTestcase.of(t->t.merge(new int[][]{{1,4},{4,5}}), new int[][]{{1,5}}))
                .build();
    }
}