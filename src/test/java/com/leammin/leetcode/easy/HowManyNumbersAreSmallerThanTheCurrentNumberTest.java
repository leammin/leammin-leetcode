package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-10-26
 */
class HowManyNumbersAreSmallerThanTheCurrentNumberTest extends AbstractTest<HowManyNumbersAreSmallerThanTheCurrentNumber> {
    @Override
    protected Testsuite<HowManyNumbersAreSmallerThanTheCurrentNumber> testsuite() {
        return Testsuite.<HowManyNumbersAreSmallerThanTheCurrentNumber>builder()
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}), new int[]{4,0,1,1,3}))
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{6,5,4,8}), new int[]{2,1,0,3}))
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{7,7,7,7}), new int[]{0,0,0,0}))
                .build();
    }
}