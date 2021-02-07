package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.LongestTurbulentSubarray;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-08
 */
class LongestTurbulentSubarrayTest extends AbstractTest<LongestTurbulentSubarray> {
    @Override
    protected Testsuite<LongestTurbulentSubarray> testsuite() {
        return Testsuite.<LongestTurbulentSubarray>builder()
                .add(ExpectedTestcase.of(t -> t.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}), 5))
                .add(ExpectedTestcase.of(t -> t.maxTurbulenceSize(new int[]{4,8,12,16}), 2))
                .add(ExpectedTestcase.of(t -> t.maxTurbulenceSize(new int[]{100}), 1))
                .build();
    }
}