package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-08
 */
class JiQiRenDeYunDongFanWeiLcofTest extends AbstractTest<JiQiRenDeYunDongFanWeiLcof> {
    @Override
    protected Testsuite<JiQiRenDeYunDongFanWeiLcof> testsuite() {
        return Testsuite.<JiQiRenDeYunDongFanWeiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.movingCount(2, 3, 1), 3))
                .add(ExpectedTestcase.of(t -> t.movingCount(3, 1, 0), 1))
                .add(ExpectedTestcase.of(t -> t.movingCount(11, 8, 16), 88))
                .add(ExpectedTestcase.of(t -> t.movingCount(38, 15, 9), 135))
                .build();
    }
}

