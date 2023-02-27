package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-27
 */
class DecreaseElementsToMakeArrayZigzagTest extends AbstractTest<DecreaseElementsToMakeArrayZigzag> {
    @Override
    protected Testsuite<DecreaseElementsToMakeArrayZigzag> testsuite() {
        return Testsuite.<DecreaseElementsToMakeArrayZigzag>builder()
                .addExpected(t -> t.movesToMakeZigzag(new int[]{1,2,3}), 2)
                .addExpected(t -> t.movesToMakeZigzag(new int[]{9,6,1,6,2}), 4)
                .build();
    }
}