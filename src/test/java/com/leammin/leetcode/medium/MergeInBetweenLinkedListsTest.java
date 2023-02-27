package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-30
 */
class MergeInBetweenLinkedListsTest extends AbstractTest<MergeInBetweenLinkedLists> {
    @Override
    protected Testsuite<MergeInBetweenLinkedLists> testsuite() {
        return Testsuite.<MergeInBetweenLinkedLists>builder()
                .addExpected(t -> t.mergeInBetween(ListNode.of(0,1,2,3,4,5), 3, 4, ListNode.of(1000000,1000001,1000002)), ListNode.of(0,1,2,1000000,1000001,1000002,5))
                .addExpected(t -> t.mergeInBetween(ListNode.of(0,1,2,3,4,5,6), 2, 5, ListNode.of(1000000,1000001,1000002,1000003,1000004)), ListNode.of(0,1,1000000,1000001,1000002,1000003,1000004,6))
                .build();
    }
}