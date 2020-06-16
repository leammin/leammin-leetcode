package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-16
 */
class RemoveLinkedListElementsTest extends AbstractTest<RemoveLinkedListElements> {
    @Override
    protected Testsuite<RemoveLinkedListElements> testsuite() {
        return Testsuite.<RemoveLinkedListElements>builder()
                .add(ExpectedTestcase.of(t -> t.removeElements(ListNode.of(1, 2, 6, 3, 4, 5, 6), 6), ListNode.of(1, 2, 3, 4, 5)))
                .build();
    }
}