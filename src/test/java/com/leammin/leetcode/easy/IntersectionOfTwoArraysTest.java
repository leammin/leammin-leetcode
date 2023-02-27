package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class IntersectionOfTwoArraysTest extends AbstractTest<IntersectionOfTwoArrays> {
    @Override
    protected Testsuite<IntersectionOfTwoArrays> testsuite() {
        return Testsuite.<IntersectionOfTwoArrays>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(2)))
                .add(VerifiableTestcase.ofConsumer(t -> t.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(9, 4)))
                .build();
    }
}