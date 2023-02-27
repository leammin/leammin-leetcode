package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Leammin
 * @date 2019-08-21
 */
class ThreeSumTest extends AbstractTest<ThreeSum> {
    @Override
    protected Testsuite<ThreeSum> testsuite() {
        return Testsuite.<ThreeSum>builder()
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4})), sort(Lists.list(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-2, -1, 0, 1, 2, -1, -4})), sort(Lists.list(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2),
                                Lists.newArrayList(-2, 0, 2)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{0, 0, 0})), sort(Lists.list(
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{0, 0, 0, 0})), sort(Lists.list(
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0})), sort(Lists.list(
                                // [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
                                Lists.newArrayList(-5, 1, 4),
                                Lists.newArrayList(-4, 0, 4),
                                Lists.newArrayList(-4, 1, 3),
                                Lists.newArrayList(-2, -2, 4),
                                Lists.newArrayList(-2, 1, 1),
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .build();

    }


    private <T extends Comparable<T>> List<List<T>> sort(List<List<T>> lists) {
        for (List<T> list : lists) {
            Collections.sort(list);
        }
        lists.sort((o1, o2) -> {
            Iterator<T> i1 = o1.iterator();
            Iterator<T> i2 = o2.iterator();
            while (i1.hasNext() && i2.hasNext()) {
                T e1 = i1.next();
                T e2 = i2.next();
                int compare = e1.compareTo(e2);
                if (compare != 0) {
                    return compare;
                }
            }
            return i1.hasNext() ? 1 : (i2.hasNext() ? -1 : 0);
        });
        return lists;
    }
}