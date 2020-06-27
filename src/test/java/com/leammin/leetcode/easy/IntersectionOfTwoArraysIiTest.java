package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class IntersectionOfTwoArraysIiTest extends AbstractTest<IntersectionOfTwoArraysIi> {
    @Override
    protected Testsuite<IntersectionOfTwoArraysIi> testsuite() {
        return Testsuite.<IntersectionOfTwoArraysIi>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(2, 2)))
                .add(VerifiableTestcase.ofConsumer(t -> t.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(4, 9)))
                .build();
    }
}