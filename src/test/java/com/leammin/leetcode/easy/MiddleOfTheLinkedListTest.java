package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;

/**
 * @author Leammin
 * @date 2020-03-23
 */
class MiddleOfTheLinkedListTest extends AbstractTest<MiddleOfTheLinkedList> {
    @Override
    protected Testsuite<MiddleOfTheLinkedList> testsuite() {
        return Testsuite.<MiddleOfTheLinkedList>builder()
                .add(VerifiableTestcase.of(t -> t.middleNode(ListNode.of(1, 2, 3, 4, 5)), res -> res.val == 3))
                .add(VerifiableTestcase.of(t -> t.middleNode(ListNode.of(1, 2, 3, 4, 5, 6)), res -> res.val == 4))
                .build();
    }
}