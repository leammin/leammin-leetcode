package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class TwoSumTest extends AbstractTest<TwoSum> {
    @Override
    protected Testsuite<TwoSum> testsuite() {
        return Testsuite.<TwoSum>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.twoSum(new int[]{2, 7, 11, 15}, 9),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(0, 1)))
                .build();
    }
}