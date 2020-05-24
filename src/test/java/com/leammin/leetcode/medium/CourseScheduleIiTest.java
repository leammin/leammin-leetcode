package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-20
 */
class CourseScheduleIiTest extends AbstractTest<CourseScheduleIi> {
    @Override
    protected Testsuite<CourseScheduleIi> testsuite() {
        return Testsuite.<CourseScheduleIi>builder()
                .add(ExpectedTestcase.of(t -> t.findOrder(2, new int[][]{{1, 0}}), new int[]{0, 1}))
                .add(ExpectedTestcase.of(t -> t.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}), new int[]{0, 1, 2, 3}))
                .add(ExpectedTestcase.of(t -> t.findOrder(2, new int[][]{{1, 0}, {0, 1}}), new int[0]))
                .build();
    }
}