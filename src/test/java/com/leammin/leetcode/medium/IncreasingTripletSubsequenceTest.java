package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-02
 */
class IncreasingTripletSubsequenceTest extends AbstractTest<IncreasingTripletSubsequence> {
    @Override
    protected Testsuite<IncreasingTripletSubsequence> testsuite() {
        return Testsuite.<IncreasingTripletSubsequence>builder()
                .add(ExpectedTestcase.of(true, t -> t.increasingTriplet(new int[]{1, 2, 3, 4, 5})))
                .add(ExpectedTestcase.of(false, t -> t.increasingTriplet(new int[]{5, 4, 3, 2, 1})))
                .add(ExpectedTestcase.of(true, t -> t.increasingTriplet(new int[]{100, 90, 95, 80, 110})))
                .add(ExpectedTestcase.of(true, t -> t.increasingTriplet(new int[]{100, 120, 80, 90, 95})))
                .build();
    }
}