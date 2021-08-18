package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-17
 */
class ErWeiShuZuZhongDeChaZhaoLcofTest extends AbstractTest<ErWeiShuZuZhongDeChaZhaoLcof> {
    @Override
    protected Testsuite<ErWeiShuZuZhongDeChaZhaoLcof> testsuite() {
        return Testsuite.<ErWeiShuZuZhongDeChaZhaoLcof>builder()
                .addExpected(t -> t.findNumberIn2DArray(new int[][]{{-5}}, -5), true)
                .build();
    }
}