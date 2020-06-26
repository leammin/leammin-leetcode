package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.undone.easy.RemoveDuplicateNodeLcci;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-26
 */
class RemoveDuplicateNodeLcciTest extends AbstractTest<RemoveDuplicateNodeLcci> {
    @Override
    protected Testsuite<RemoveDuplicateNodeLcci> testsuite() {
        return Testsuite.<RemoveDuplicateNodeLcci>builder()
                .add(ExpectedTestcase.of(t -> t.removeDuplicateNodes(ListNode.of(1, 2, 3, 3, 2, 1)), ListNode.of(1, 2, 3)))
                .add(ExpectedTestcase.of(t -> t.removeDuplicateNodes(ListNode.of(1, 1, 1, 1, 2)), ListNode.of(1, 2)))
                .build();
    }
}