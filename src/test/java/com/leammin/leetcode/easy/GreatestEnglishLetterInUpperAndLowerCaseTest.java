package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-29
 */
class GreatestEnglishLetterInUpperAndLowerCaseTest extends AbstractTest<GreatestEnglishLetterInUpperAndLowerCase> {
    @Override
    protected Testsuite<GreatestEnglishLetterInUpperAndLowerCase> testsuite() {
        return Testsuite.<GreatestEnglishLetterInUpperAndLowerCase>builder()
                .addExpected(t -> t.greatestLetter("lEeTcOdE"), "E")
                .addExpected(t -> t.greatestLetter("arRAzFif"), "R")
                .addExpected(t -> t.greatestLetter("AbCdEfGhIjK"), "")
                .build();
    }
}