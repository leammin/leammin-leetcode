package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-07-14
 */
class TriangleTest extends AbstractTest<Triangle> {
    @Override
    protected Testsuite<Triangle> testsuite() {
        return Testsuite.<Triangle>builder()
                .add(ExpectedTestcase.of(t -> t.minimumTotal(List.of(
                        List.of(2),
                        List.of(3,4),
                        List.of(6,5,7),
                        List.of(4,1,8,3)
                )), 11))
                .build();
    }
}