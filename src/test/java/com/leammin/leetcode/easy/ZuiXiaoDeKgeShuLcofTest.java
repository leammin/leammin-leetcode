package com.leammin.leetcode.easy;

import com.google.common.primitives.Ints;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-20
 */
class ZuiXiaoDeKgeShuLcofTest extends AbstractTest<ZuiXiaoDeKgeShuLcof> {
    @Override
    protected Testsuite<ZuiXiaoDeKgeShuLcof> testsuite() {
        return Testsuite.<ZuiXiaoDeKgeShuLcof>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{3, 2, 1}, 2), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(1, 2)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 1, 2, 1}, 1), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 1, 2, 1}, 3), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0, 1, 1)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder()
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0, 0, 1, 1, 2, 2, 2, 3)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{3, 2, 1}, 2), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(1, 2)
                ))
                .build();
    }
}