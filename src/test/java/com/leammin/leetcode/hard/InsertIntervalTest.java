package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-11-04
 */
class InsertIntervalTest extends AbstractTest<InsertInterval> {
    @Override
    protected Testsuite<InsertInterval> testsuite() {
        return Testsuite.<InsertInterval>builder()
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}),
                        new int[][]{{1, 5}, {6, 9}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8}), new int[][]{{1, 2}, {3, 10}, {12, 16}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{},
                        new int[]{5, 7}), new int[][]{{5, 7}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{2, 3}), new int[][]{{1, 5}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{6, 8}), new int[][]{{1, 5}, {6, 8}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{0, 0}), new int[][]{{0, 0}, {1, 5}}))
                .build();
    }
}