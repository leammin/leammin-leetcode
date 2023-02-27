package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-18
 */
class FindSmallestLetterGreaterThanTargetTest extends AbstractTest<FindSmallestLetterGreaterThanTarget> {
    @Override
    protected Testsuite<FindSmallestLetterGreaterThanTarget> testsuite() {
        return Testsuite.<FindSmallestLetterGreaterThanTarget>builder()
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'a'), 'c'))
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'c'), 'f'))
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'd'), 'f'))
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'g'), 'j'))
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'j'), 'c'))
                .add(ExpectedTestcase.of(t -> t.nextGreatestLetter(new char[]{'c', 'f','j'}, 'k'), 'c'))
                .build();
    }
}