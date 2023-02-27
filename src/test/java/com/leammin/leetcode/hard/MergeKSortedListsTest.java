package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-26
 */
class MergeKSortedListsTest extends AbstractTest<MergeKSortedLists> {
    @Override
    protected Testsuite<MergeKSortedLists> testsuite() {
        return Testsuite.<MergeKSortedLists>builder()
                .add(ExpectedTestcase.of(t -> t.mergeKLists(new ListNode[]{
                                ListNode.of(1, 4, 5),
                                ListNode.of(1, 3, 4),
                                ListNode.of(2, 6)}),
                        ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)))
                .add(ExpectedTestcase.of(t -> t.mergeKLists(new ListNode[]{null}),
                        ListNode.of()))
                .build();
    }
}