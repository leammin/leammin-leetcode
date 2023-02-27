package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class FirstUniqueCharacterInAStringTest extends AbstractTest<FirstUniqueCharacterInAString> {
    @Override
    protected Testsuite<FirstUniqueCharacterInAString> testsuite() {
        return Testsuite.<FirstUniqueCharacterInAString>builder()
                .add(ExpectedTestcase.of(t -> t.firstUniqChar("leetcode"), 0))
                .add(ExpectedTestcase.of(t -> t.firstUniqChar("loveleetcode"), 2))
                .build();
    }
}