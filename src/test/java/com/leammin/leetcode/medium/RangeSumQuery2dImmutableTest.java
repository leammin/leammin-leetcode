package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-02
 */
class RangeSumQuery2dImmutableTest extends AbstractTest<RangeSumQuery2dImmutable> {
    @Override
    protected Testsuite<RangeSumQuery2dImmutable> testsuite() {
        return Testsuite.<RangeSumQuery2dImmutable>builder()
                .add(ExpectedTestcase.create(clazz -> ClassUtils.newInstance(clazz, (Object) new int[][]{
                                {3, 0, 1, 4, 2},
                                {5, 6, 3, 2, 1},
                                {1, 2, 0, 1, 5},
                                {4, 1, 0, 1, 7},
                                {1, 0, 3, 0, 5}
                        }), t -> new int[]{
                                t.sumRegion(2, 1, 4, 3),
                                t.sumRegion(1, 1, 2, 2),
                                t.sumRegion(1, 2, 2, 4),
                        }, new int[]{8, 11, 12})
                )
                .build();
    }
}