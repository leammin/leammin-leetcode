package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-09-08
 */
class ShanChuLianBiaoDeJieDianLcofTest extends AbstractTest<ShanChuLianBiaoDeJieDianLcof> {
    @Override
    protected Testsuite<ShanChuLianBiaoDeJieDianLcof> testsuite() {
        return Testsuite.<ShanChuLianBiaoDeJieDianLcof>builder()
                .addExpected(t -> t.deleteNode(ListNode.of(4, 5, 1, 9), 5), ListNode.of(4, 1, 9))
                .addExpected(t -> t.deleteNode(ListNode.of(4, 5, 1, 9), 1), ListNode.of(4, 5, 9))
                .build();
    }
}