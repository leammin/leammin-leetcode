package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-16
 */
class ShuZuZhongZhongFuDeShuZiLcofTest extends AbstractTest<ShuZuZhongZhongFuDeShuZiLcof> {
    @Override
    protected Testsuite<ShuZuZhongZhongFuDeShuZiLcof> testsuite() {
        return Testsuite.<ShuZuZhongZhongFuDeShuZiLcof>builder()
                .addExpected(t -> t.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}), 2)
                .build();
    }
}