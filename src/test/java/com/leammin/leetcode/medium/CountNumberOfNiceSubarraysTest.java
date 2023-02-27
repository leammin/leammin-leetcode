package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-21
 */
class CountNumberOfNiceSubarraysTest extends AbstractTest<CountNumberOfNiceSubarrays> {
    @Override
    protected Testsuite<CountNumberOfNiceSubarrays> testsuite() {
        return Testsuite.<CountNumberOfNiceSubarrays>builder()
                .add(ExpectedTestcase.of(t -> t.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3), 2))
                .add(ExpectedTestcase.of(t -> t.numberOfSubarrays(new int[]{2,4,6}, 1), 0))
                .add(ExpectedTestcase.of(t -> t.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2), 16))
                .add(ExpectedTestcase.of(t -> t.numberOfSubarrays(new int[]{1,1,1,1,1}, 1), 5))
                .build();
    }
}