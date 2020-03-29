package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-28
 */
class TopKFrequentElementsTest extends AbstractTest<TopKFrequentElements> {
    @Override
    protected Testsuite<TopKFrequentElements> testsuite() {
        return Testsuite.<TopKFrequentElements>builder()
                .add(VerifiableTestcase.ofConsumer(res -> Assertions.assertThat(res).containsExactlyInAnyOrder(1, 2),
                        t -> t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)))
                .add(VerifiableTestcase.ofConsumer(res -> Assertions.assertThat(res).containsExactlyInAnyOrder(1),
                        t -> t.topKFrequent(new int[]{1}, 1)))
                .build();
    }
}