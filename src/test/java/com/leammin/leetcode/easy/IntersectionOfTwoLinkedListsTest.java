package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.ListNodeUtils;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-10
 */
class IntersectionOfTwoLinkedListsTest extends AbstractTest<IntersectionOfTwoLinkedLists> {
    @Override
    protected Testsuite<IntersectionOfTwoLinkedLists> testsuite() {
        ListNode case1 = ListNode.of(8, 4, 5);
        ListNode case1A = ListNode.of(4, 1);
        ListNodeUtils.tail(case1A).next = case1;
        ListNode case1B = ListNode.of(5, 0, 1);
        ListNodeUtils.tail(case1B).next = case1;

        ListNode case2 = ListNode.of(2, 4);
        ListNode case2A = ListNode.of(0, 9, 1);
        ListNodeUtils.tail(case2A).next = case2;
        ListNode case2B = ListNode.of(3);
        ListNodeUtils.tail(case2B).next = case2;

        return Testsuite.<IntersectionOfTwoLinkedLists>builder()
                .add(ExpectedTestcase.of(t -> t.getIntersectionNode(case1A, case1B), case1))
                .add(ExpectedTestcase.of(t -> t.getIntersectionNode(case2A, case2B), case2))
                .add(ExpectedTestcase.of(t -> t.getIntersectionNode(ListNode.of(2, 6, 4), ListNode.of(1, 5)), null))
                .build();
    }
}