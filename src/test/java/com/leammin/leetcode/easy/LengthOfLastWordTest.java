package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-10
 */
class LengthOfLastWordTest extends AbstractTest<LengthOfLastWord> {
    @Override
    protected Testsuite<LengthOfLastWord> testsuite() {
        return Testsuite.<LengthOfLastWord>builder()
                .addExpected(t -> t.lengthOfLastWord("Hello World"), 5)
                .addExpected(t -> t.lengthOfLastWord("HelloWorld"), 10)
                .addExpected(t -> t.lengthOfLastWord("HelloWorld "), 10)
                .addExpected(t -> t.lengthOfLastWord(" HelloWorld"), 10)
                .build();
    }
}