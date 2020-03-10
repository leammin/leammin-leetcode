package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-09
 */
class OddEvenLinkedListTest extends AbstractTest<OddEvenLinkedList> {
    @Override
    protected Testsuite<OddEvenLinkedList> testsuite() {
        return Testsuite.<OddEvenLinkedList>builder()
                .add(ExpectedTestcase.of(ListNode.of(1, 3, 5, 7, 2, 4, 6), t -> t.oddEvenList(ListNode.of(1, 2, 3, 4, 5, 6, 7))))
                .add(ExpectedTestcase.of(ListNode.of(1, 3, 5, 7, 9, 2, 4, 6, 8, 10), t -> t.oddEvenList(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))))
                .build();
    }
}