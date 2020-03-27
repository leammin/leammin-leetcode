package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-26
 */
class AvailableCapturesForRookTest extends AbstractTest<AvailableCapturesForRook> {
    @Override
    protected Testsuite<AvailableCapturesForRook> testsuite() {
        return Testsuite.<AvailableCapturesForRook>builder()
                .add(ExpectedTestcase.of(3, t -> t.numRookCaptures(new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'B', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}})))
                .build();
    }
}