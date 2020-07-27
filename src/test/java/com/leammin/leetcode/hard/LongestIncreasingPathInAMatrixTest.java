package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.LongestIncreasingPathInAMatrix;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-26
 */
class LongestIncreasingPathInAMatrixTest extends AbstractTest<LongestIncreasingPathInAMatrix> {
    @Override
    protected Testsuite<LongestIncreasingPathInAMatrix> testsuite() {
        return Testsuite.<LongestIncreasingPathInAMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.longestIncreasingPath(new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }), 4))
                .add(ExpectedTestcase.of(t -> t.longestIncreasingPath(new int[][]{
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}
                }), 4))
                .build();
    }
}