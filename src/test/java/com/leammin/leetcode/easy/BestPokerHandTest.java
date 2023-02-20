package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-20
 */
class BestPokerHandTest extends AbstractTest<BestPokerHand> {
    @Override
    protected Testsuite<BestPokerHand> testsuite() {
        return Testsuite.<BestPokerHand>builder()
                .addExpected(t -> t.bestHand(new int[]{13,2,3,1,9}, new char[]{'a', 'a', 'a', 'a', 'a'}), "Flush")
                .build();
    }
}