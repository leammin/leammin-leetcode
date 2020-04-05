package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-03
 */
class SearchA2dMatrixTest extends AbstractTest<SearchA2dMatrix> {
    @Override
    protected Testsuite<SearchA2dMatrix> testsuite() {
        return Testsuite.<SearchA2dMatrix>builder()
                .add(ExpectedTestcase.of(true, t -> t.searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 3)))
                .add(ExpectedTestcase.of(false, t -> t.searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 13)))
                .add(ExpectedTestcase.of(true, t -> t.searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5)))
                .add(ExpectedTestcase.of(true, t -> t.searchMatrix(new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
                }, 5)))
                .build();
    }
}