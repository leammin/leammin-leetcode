package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-29
 */
class AsFarFromLandAsPossibleTest extends AbstractTest<AsFarFromLandAsPossible> {
    @Override
    protected Testsuite<AsFarFromLandAsPossible> testsuite() {
        return Testsuite.<AsFarFromLandAsPossible>builder()
                .add(ExpectedTestcase.of(2, t -> t.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}})))
                .add(ExpectedTestcase.of(4, t -> t.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}})))
                .build();
    }
}