package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.ListNodeUtils;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-16
 */
class LinkedListCycleIiTest extends AbstractTest<LinkedListCycleIi> {
    @Override
    protected Testsuite<LinkedListCycleIi> testsuite() {
        return Testsuite.<LinkedListCycleIi>builder()
                .add(ExpectedTestcase.of(t -> {
                    ListNode list = ListNode.of(2, 0, -4);
                    ListNodeUtils.tail(list).next = list;
                    ListNode head = ListNode.of(3);
                    head.next = list;
                    return t.detectCycle(head).val;
                }, 2))
                .build();
    }
}