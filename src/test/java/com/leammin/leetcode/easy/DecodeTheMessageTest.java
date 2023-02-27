package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-01
 */
class DecodeTheMessageTest extends AbstractTest<DecodeTheMessage> {
    @Override
    protected Testsuite<DecodeTheMessage> testsuite() {
        return Testsuite.<DecodeTheMessage>builder()
                .addExpected(t -> t.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"), "this is a secret")
                .addExpected(t -> t.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"), "the five boxing wizards jump quickly")
                .build();
    }
}