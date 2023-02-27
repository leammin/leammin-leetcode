package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-22
 */
class QingWaTiaoTaiJieWenTiLcofTest extends AbstractTest<QingWaTiaoTaiJieWenTiLcof> {
    @Override
    protected Testsuite<QingWaTiaoTaiJieWenTiLcof> testsuite() {
        return Testsuite.<QingWaTiaoTaiJieWenTiLcof>builder()
                .addExpected(t -> t.numWays(2), 2)
                .addExpected(t -> t.numWays(7), 21)
                .build();
    }
}