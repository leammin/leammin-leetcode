package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-24
 */
class JuZhenZhongDeLuJingLcofTest extends AbstractTest<JuZhenZhongDeLuJingLcof> {
    @Override
    protected Testsuite<JuZhenZhongDeLuJingLcof> testsuite() {
        return Testsuite.<JuZhenZhongDeLuJingLcof>builder()
                .addExpected(t -> t.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"), true)
                .addExpected(t -> t.exist(new char[][]{{'A'}}, "AB"), false)
                .build();
    }
}