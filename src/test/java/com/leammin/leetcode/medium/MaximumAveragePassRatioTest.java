package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

/**
 * @author Leammin
 * @date 2023-02-19
 */
class MaximumAveragePassRatioTest extends AbstractTest<MaximumAveragePassRatio> {
    @Override
    protected Testsuite<MaximumAveragePassRatio> testsuite() {
        return Testsuite.<MaximumAveragePassRatio>builder()
                .addConsumer(t -> t.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2),
                        output -> Assertions.assertThat(output).isCloseTo(0.78333, Offset.offset(0.00001)))
                .addConsumer(t -> t.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4),
                        output -> Assertions.assertThat(output).isCloseTo(0.53485, Offset.offset(0.00001)))
                .build();
    }
}