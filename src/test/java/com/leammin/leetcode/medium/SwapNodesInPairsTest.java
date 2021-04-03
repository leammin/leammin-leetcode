package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-03
 */
class SwapNodesInPairsTest extends AbstractTest<SwapNodesInPairs> {
    @Override
    protected Testsuite<SwapNodesInPairs> testsuite() {
        return Testsuite.<SwapNodesInPairs>builder()
                .addExpected(t -> t.swapPairs(ListNode.of(1, 2, 3, 4)), ListNode.of(2, 1, 4, 3))
                .build();
    }
}