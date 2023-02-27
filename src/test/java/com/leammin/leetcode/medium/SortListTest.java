package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.*;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Leammin
 * @date 2021-01-10
 */
class SortListTest extends AbstractTest<SortList> {
    @Override
    protected Testsuite<SortList> testsuite() {
        return Testsuite.<SortList>builder()
                .add(ExpectedTestcase.of(t -> t.sortList(ListNode.of(4, 2, 1, 3)), ListNode.of(1, 2, 3, 4)))
                .add(ExpectedTestcase.of(t -> t.sortList(ListNode.of(-1, 5, 3, 4, 0)), ListNode.of(-1, 0, 3, 4, 5)))
                .add(Testcase.of(t -> {
                    long now = System.nanoTime();
                    for (int times = 0; times < 10000; times++) {
                        Random random = new Random();
                        int[] array = new int[1000];
                        for (int i = 0; i < array.length; i++) {
                            array[i] = random.nextInt(200001) - 100000;
                        }
                        try {
                            ListNode output = t.sortList(ListNode.of(array));
                            Arrays.sort(array);
                            ListNode expected = ListNode.of(array);
                            Assertions.assertThat(output).as(ClassUtils.getName(t)).isEqualTo(expected);
                        } catch (Error error) {
                            logger.error("array is : {}", array);
                            throw error;
                        }
                    }
                    return System.nanoTime() - now;
                }))
                .build();
    }
}