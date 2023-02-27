package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-10
 */
class RemoveDuplicatesFromSortedListTest extends AbstractTest<RemoveDuplicatesFromSortedList> {
    @Override
    protected Testsuite<RemoveDuplicatesFromSortedList> testsuite() {
        return Testsuite.<RemoveDuplicatesFromSortedList>builder()
                .addExpected(t -> t.deleteDuplicates(ListNode.of(1, 1, 2)), ListNode.of(1, 2))
                .addExpected(t -> t.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3)), ListNode.of(1, 2, 3))
                .addExpected(t -> t.deleteDuplicates(ListNode.of(1, 1, 1)), ListNode.of(1))
                .build();
    }
}