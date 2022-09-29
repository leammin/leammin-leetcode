package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.StringRotationLcci;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-29
 */
class StringRotationLcciTest extends AbstractTest<StringRotationLcci> {
    @Override
    protected Testsuite<StringRotationLcci> testsuite() {
        return Testsuite.<StringRotationLcci>builder()
                .addExpected(t -> t.isFlipedString("waterbottle", "erbottlewat"), true)
                .addExpected(t -> t.isFlipedString("aa", "ab"), false)
                .build();
    }
}