package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.ThreeSum;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;
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
                        sort(Lists.newArrayList(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2)
                        )),
                        t -> sort(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}))
                ))
                .add(ExpectedTestcase.of(
                        sort(Lists.newArrayList(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2),
                                Lists.newArrayList(-2, 0, 2)
                        )),
                        t -> sort(t.threeSum(new int[]{-2,-1, 0, 1, 2, -1, -4}))
                ))
                .build();

    }


    private <T extends Comparable<T>> List<? extends List<T>> sort(List<? extends List<T>> lists) {
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