package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-19
 */
class CongWeiDaoTouDaYinLianBiaoLcofTest extends AbstractTest<CongWeiDaoTouDaYinLianBiaoLcof> {
    @Override
    protected Testsuite<CongWeiDaoTouDaYinLianBiaoLcof> testsuite() {
        return Testsuite.<CongWeiDaoTouDaYinLianBiaoLcof>builder()
                .addExpected(t -> t.reversePrint(ListNode.of(1,3,2)), new int[]{2,3,1})
                .build();
    }
}