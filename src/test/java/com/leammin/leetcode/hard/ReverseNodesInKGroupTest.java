package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-20
 */
class ReverseNodesInKGroupTest extends AbstractTest<ReverseNodesInKGroup> {
    @Override
    protected Testsuite<ReverseNodesInKGroup> testsuite() {
        return Testsuite.<ReverseNodesInKGroup>builder()
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2), ListNode.of(2, 1, 4, 3, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3), ListNode.of(3, 2, 1, 4, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 5), ListNode.of(5, 4, 3, 2, 1)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 0), ListNode.of(1, 2, 3, 4, 5)))
                .build();
    }
}