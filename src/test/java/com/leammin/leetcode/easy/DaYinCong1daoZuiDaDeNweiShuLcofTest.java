package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-09-07
 */
class DaYinCong1daoZuiDaDeNweiShuLcofTest extends AbstractTest<DaYinCong1daoZuiDaDeNweiShuLcof> {
    @Override
    protected Testsuite<DaYinCong1daoZuiDaDeNweiShuLcof> testsuite() {
        return Testsuite.<DaYinCong1daoZuiDaDeNweiShuLcof>builder()
                .addExpected(t -> t.printNumbers(1), new int[]{1,2,3,4,5,6,7,8,9})
                .build();
    }
}