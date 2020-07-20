package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-16
 */
class IsGraphBipartiteTest extends AbstractTest<IsGraphBipartite> {
    @Override
    protected Testsuite<IsGraphBipartite> testsuite() {
        return Testsuite.<IsGraphBipartite>builder()
                .add(ExpectedTestcase.of(t -> t.isBipartite(new int[][]{
                        {1, 3}, {0, 2}, {1, 3}, {0, 2}
                }), true))
                .add(ExpectedTestcase.of(t -> t.isBipartite(new int[][]{
                        {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
                }), false))
                .add(ExpectedTestcase.of(t -> t.isBipartite(new int[][]{
                        {}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}
                }), false))
                .add(ExpectedTestcase.of(t -> t.isBipartite(new int[][]{
                        {4}, {}, {4}, {4}, {0, 2, 3}
                }), true))
                .build();
    }

}