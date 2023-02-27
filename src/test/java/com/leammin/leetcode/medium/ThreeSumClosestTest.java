package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-24
 */
class ThreeSumClosestTest extends AbstractTest<ThreeSumClosest> {
    @Override
    protected Testsuite<ThreeSumClosest> testsuite() {
        return Testsuite.<ThreeSumClosest>builder()
                .add(ExpectedTestcase.of(t -> t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2))
                .build();
    }
}