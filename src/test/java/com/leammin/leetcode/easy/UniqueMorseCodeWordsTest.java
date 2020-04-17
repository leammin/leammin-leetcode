package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-21
 */
class UniqueMorseCodeWordsTest extends AbstractTest<UniqueMorseCodeWords> {
    @Override
    protected Testsuite<UniqueMorseCodeWords> testsuite() {
        return Testsuite.<UniqueMorseCodeWords>builder()
                .add(ExpectedTestcase.of(t -> t.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}), 2))
                .build();
    }
}