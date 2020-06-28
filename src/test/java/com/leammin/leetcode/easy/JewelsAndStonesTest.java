package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class JewelsAndStonesTest extends AbstractTest<JewelsAndStones> {
    @Override
    protected Testsuite<JewelsAndStones> testsuite() {
        return Testsuite.<JewelsAndStones>builder()
                .add(ExpectedTestcase.of(t -> t.numJewelsInStones("aA", "aAAbbbb"), 3))
                .add(ExpectedTestcase.of(t -> t.numJewelsInStones("z", "ZZ"), 0))
                .build();
    }
}