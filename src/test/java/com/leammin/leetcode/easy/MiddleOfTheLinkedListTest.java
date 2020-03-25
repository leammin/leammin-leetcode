package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;

/**
 * @author Leammin
 * @date 2020-03-23
 */
class MiddleOfTheLinkedListTest extends AbstractTest<MiddleOfTheLinkedList> {
    @Override
    protected Testsuite<MiddleOfTheLinkedList> testsuite() {
        return Testsuite.<MiddleOfTheLinkedList>builder()
                .add(VerifiableTestcase.of(res -> res.val == 3, t -> t.middleNode(ListNode.of(1, 2, 3, 4, 5))))
                .add(VerifiableTestcase.of(res -> res.val == 4, t -> t.middleNode(ListNode.of(1, 2, 3, 4, 5, 6))))
                .build();
    }
}