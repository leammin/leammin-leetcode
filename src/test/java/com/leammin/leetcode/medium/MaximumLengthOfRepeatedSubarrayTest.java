package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.MaximumLengthOfRepeatedSubarray;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-01
 */
class MaximumLengthOfRepeatedSubarrayTest extends AbstractTest<MaximumLengthOfRepeatedSubarray> {
    @Override
    protected Testsuite<MaximumLengthOfRepeatedSubarray> testsuite() {
        return Testsuite.<MaximumLengthOfRepeatedSubarray>builder()
                .add(ExpectedTestcase.of(t -> t.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}), 3))
                .build();
    }
}