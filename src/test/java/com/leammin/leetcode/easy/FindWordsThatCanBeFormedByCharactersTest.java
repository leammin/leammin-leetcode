package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-17
 */
class FindWordsThatCanBeFormedByCharactersTest extends AbstractTest<FindWordsThatCanBeFormedByCharacters> {
    @Override
    protected Testsuite<FindWordsThatCanBeFormedByCharacters> testsuite() {
        return Testsuite.<FindWordsThatCanBeFormedByCharacters>builder()
                .add(ExpectedTestcase.of(6, t -> t.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach")))
                .add(ExpectedTestcase.of(10, t -> t.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr")))
                .build();
    }
}