package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.L4xy4Wx;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-05
 */
class L4xy4WxTest extends AbstractTest<L4xy4Wx> {
    @Override
    protected Testsuite<L4xy4Wx> testsuite() {
        return Testsuite.<L4xy4Wx>builder()
                .addExpected(t -> t.purchasePlans(new int[]{2, 5, 3, 5}, 6), 1)
                .addExpected(t -> t.purchasePlans(new int[]{2, 2, 1, 9}, 10), 4)
                .build();
    }
}