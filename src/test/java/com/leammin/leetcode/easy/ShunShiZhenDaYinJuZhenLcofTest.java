package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-05
 */
class ShunShiZhenDaYinJuZhenLcofTest extends AbstractTest<ShunShiZhenDaYinJuZhenLcof> {
    @Override
    protected Testsuite<ShunShiZhenDaYinJuZhenLcof> testsuite() {
        return Testsuite.<ShunShiZhenDaYinJuZhenLcof>builder()
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }), new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }), new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4, 13},
                        {5, 6, 7, 8, 14},
                        {9, 10, 11, 12, 15}
                }), new int[]{1, 2, 3, 4, 13, 14, 15, 12, 11, 10, 9, 5, 6, 7, 8}))
                .build();
    }
}