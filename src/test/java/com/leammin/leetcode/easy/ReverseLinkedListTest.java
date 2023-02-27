package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-20
 */
class ReverseLinkedListTest extends AbstractTest<ReverseLinkedList> {
    @Override
    protected Testsuite<ReverseLinkedList> testsuite() {
        return Testsuite.<ReverseLinkedList>builder()
                .add(ExpectedTestcase.of(t -> t.reverseList(ListNode.of(5, 3, 2, 1, 0)), ListNode.of(0, 1, 2, 3, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseList(ListNode.of(5, 3, 2, 1, 3)), ListNode.of(3, 1, 2, 3, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseList(ListNode.of(5)), ListNode.of(5)))
                .add(ExpectedTestcase.of(t -> t.reverseList(ListNode.of(3, 5)), ListNode.of(5, 3)))
                .build();
    }
}