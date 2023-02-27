package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-09
 */
class MapSumPairsTest extends AbstractTest<MapSumPairs> {
    @Override
    protected Testsuite<MapSumPairs> testsuite() {
        return Testsuite.<MapSumPairs>builder()
                .addExpected(t -> {
                    List<Integer> res = new ArrayList<>();
                    t.insert("apple", 3);
                    res.add(t.sum("ap"));
                    t.insert("app", 2);
                    res.add(t.sum("ap"));
                    return res;
                }, List.of(3, 5))
                .build();
    }
}