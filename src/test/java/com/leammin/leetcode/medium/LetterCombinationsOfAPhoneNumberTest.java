package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Leammin
 * @date 2020-03-19
 */
class LetterCombinationsOfAPhoneNumberTest extends AbstractTest<LetterCombinationsOfAPhoneNumber> {
    @Override
    protected Testsuite<LetterCombinationsOfAPhoneNumber> testsuite() {
        return Testsuite.<LetterCombinationsOfAPhoneNumber>builder()
                .add(ExpectedTestcase.of(t -> new HashSet<>(t.letterCombinations("23")), Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
                ))
                .build();
    }
}