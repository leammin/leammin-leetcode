package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-20
 */
class DegreeOfAnArrayTest extends AbstractTest<DegreeOfAnArray> {
    @Override
    protected Testsuite<DegreeOfAnArray> testsuite() {
        return Testsuite.<DegreeOfAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.findShortestSubArray(new int[]{1, 2, 2, 3, 1}), 2))
                .add(ExpectedTestcase.of(t -> t.findShortestSubArray(new int[]{1,2,2,3,1,4,2}), 6))
                .build();
    }
}