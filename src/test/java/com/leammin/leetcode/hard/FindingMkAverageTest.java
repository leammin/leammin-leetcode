package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-11
 */
class FindingMkAverageTest extends AbstractTest<FindingMkAverage> {
    @Override
    protected Testsuite<FindingMkAverage> testsuite() {
        return Testsuite.<FindingMkAverage>builder()
                .add(ExpectedTestcase.create(c -> ClassUtils.newInstance(c, 3, 1), t -> {
                    List<Integer> res = new ArrayList<>();
                    t.addElement(3);
                    t.addElement(1);
                    res.add(t.calculateMKAverage());
                    t.addElement(10);
                    res.add(t.calculateMKAverage());
                    t.addElement(5);
                    t.addElement(5);
                    t.addElement(5);
                    res.add(t.calculateMKAverage());
                    return res;
                }, List.of(-1, 3, 5)))
                .add(ExpectedTestcase.create(c -> ClassUtils.newInstance(c, 3, 1), t -> {
                    List<Integer> res = new ArrayList<>();
                    t.addElement(17612);
                    t.addElement(74607);
                    res.add(t.calculateMKAverage());
                    t.addElement(8272);
                    t.addElement(33433);
                    res.add(t.calculateMKAverage());
                    t.addElement(15456);
                    t.addElement(64938);
                    res.add(t.calculateMKAverage());
                    t.addElement(99741);
                    return res;
                }, List.of(-1, 33433, 33433)))
                .build();
    }
}