package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-17
 */
class RotateListTest extends AbstractTest<RotateList> {
    @Override
    protected Testsuite<RotateList> testsuite() {
        return Testsuite.<RotateList>builder()
                .add(ExpectedTestcase.of(t -> t.rotateRight(ListNode.of(1, 2, 3, 4, 5), 2), ListNode.of(4, 5, 1, 2, 3)))
                .add(ExpectedTestcase.of(t -> t.rotateRight(ListNode.of(1, 2, 3, 4, 5), 5), ListNode.of(1, 2, 3, 4, 5)))
                .add(ExpectedTestcase.of(t -> t.rotateRight(ListNode.of(0, 1, 2), 4), ListNode.of(2, 0, 1)))
                .build();
    }
}