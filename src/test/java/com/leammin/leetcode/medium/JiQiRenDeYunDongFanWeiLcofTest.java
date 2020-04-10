package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.JiQiRenDeYunDongFanWeiLcof;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-08
 */
class JiQiRenDeYunDongFanWeiLcofTest extends AbstractTest<JiQiRenDeYunDongFanWeiLcof> {
    @Override
    protected Testsuite<JiQiRenDeYunDongFanWeiLcof> testsuite() {
        return Testsuite.<JiQiRenDeYunDongFanWeiLcof>builder()
                .add(ExpectedTestcase.of(3, t -> t.movingCount(2, 3, 1)))
                .add(ExpectedTestcase.of(1, t -> t.movingCount(3, 1, 0)))
                .add(ExpectedTestcase.of(88, t -> t.movingCount(11, 8, 16)))
                .add(ExpectedTestcase.of(135, t -> t.movingCount(38, 15, 9)))
                .build(2);
    }
}

