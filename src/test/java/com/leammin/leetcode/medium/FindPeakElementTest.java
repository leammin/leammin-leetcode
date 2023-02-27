package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-31
 */
class FindPeakElementTest extends AbstractTest<FindPeakElement> {
    @Override
    protected Testsuite<FindPeakElement> testsuite() {
        return Testsuite.<FindPeakElement>builder()
                .add(ExpectedTestcase.of(t -> t.findPeakElement(new int[]{1, 2, 3, 1}), 2))
                .add(VerifiableTestcase.ofConsumer(t -> t.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}), res -> Assertions.assertThat(res).isIn(1, 5)))
                .build();
    }
}