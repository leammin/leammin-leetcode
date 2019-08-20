package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-20
 */
class ReverseLinkedListTest extends AbstractTest<ReverseLinkedList> {
    @Override
    protected Testsuite<ReverseLinkedList> testsuite() {
        return Testsuite.<ReverseLinkedList>builder()
                .add(ExpectedTestcase.of(ListNode.of(0, 1, 2, 3, 5), t -> t.reverseList(ListNode.of(5, 3, 2, 1, 0))))
                .add(ExpectedTestcase.of(ListNode.of(3, 1, 2, 3, 5), t -> t.reverseList(ListNode.of(5, 3, 2, 1, 3))))
                .add(ExpectedTestcase.of(ListNode.of(5), t -> t.reverseList(ListNode.of(5))))
                .add(ExpectedTestcase.of(ListNode.of(5, 3), t -> t.reverseList(ListNode.of(3, 5))))
                .build();
    }
}