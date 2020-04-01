package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-31
 */
class FindPeakElementTest extends AbstractTest<FindPeakElement> {
    @Override
    protected Testsuite<FindPeakElement> testsuite() {
        return Testsuite.<FindPeakElement>builder()
                .add(ExpectedTestcase.of(2, t -> t.findPeakElement(new int[]{1, 2, 3, 1})))
                .add(VerifiableTestcase.ofConsumer(res -> Assertions.assertThat(res).isIn(1, 5), t -> t.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})))
                .build();
    }
}