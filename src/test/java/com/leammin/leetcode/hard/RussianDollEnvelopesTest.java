package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-04
 */
class RussianDollEnvelopesTest extends AbstractTest<RussianDollEnvelopes> {
    @Override
    protected Testsuite<RussianDollEnvelopes> testsuite() {
        return Testsuite.<RussianDollEnvelopes>builder()
                .add(ExpectedTestcase.of(t -> t.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}), 3))
                .add(ExpectedTestcase.of(t -> t.maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{5,5},{6,7},{7,8}}), 7))
                .add(ExpectedTestcase.of(t -> t.maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,5},{5,6},{6,1},{7,7},{8,8}}), 7))
                .add(ExpectedTestcase.of(t -> t.maxEnvelopes(new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}}), 5))
                .build();
    }
}