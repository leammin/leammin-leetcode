package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-03-22
 */
class SubsetsTest extends AbstractTest<Subsets> {
    @Override
    protected Testsuite<Subsets> testsuite() {
        return Testsuite.<Subsets>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.subsets(new int[]{1, 2, 3}), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        List.of(3),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2, 3),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2),
                        List.of())
                ))
                .build();
    }
}