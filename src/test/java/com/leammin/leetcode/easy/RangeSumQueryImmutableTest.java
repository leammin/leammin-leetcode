package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2019-04-07
 */
class RangeSumQueryImmutableTest extends AbstractTest<RangeSumQueryImmutable> {
    @Override
    protected Testsuite<RangeSumQueryImmutable> testsuite() {
        return Testsuite.<RangeSumQueryImmutable>builder()
                .add(Testcase.create(
                        clazz -> ClassUtils.newInstance(clazz, (Object) new int[]{-2, 0, 3, -5, 2, -1}),
                        solution -> {
                            String name = ClassUtils.getName(solution);
                            // sumRange(0, 2) -> 1
                            // sumRange(2, 5) -> -1
                            // sumRange(0, 5) -> -3
                            long before = System.nanoTime();
                            int a = solution.sumRange(0, 2);
                            int b = solution.sumRange(2, 5);
                            int c = solution.sumRange(0, 5);
                            long time = System.nanoTime() - before;

                            Assertions.assertThat(a).as(name).isEqualTo(1);
                            Assertions.assertThat(b).as(name).isEqualTo(-1);
                            Assertions.assertThat(c).as(name).isEqualTo(-3);
                            return time;
                        }))
                .add(Testcase.create(
                        clazz -> ClassUtils.newInstance(clazz, (Object) new int[]{-2, 0, 3, -5, 2, -1}),
                        solution -> {
                            String name = ClassUtils.getName(solution);
                            // sumRange(0, 2) -> 1
                            // sumRange(2, 5) -> -1
                            // sumRange(0, 5) -> -3
                            long before = System.nanoTime();
                            int a = solution.sumRange(0, 2);
                            int b = solution.sumRange(2, 5);
                            int c = solution.sumRange(0, 5);
                            long time = System.nanoTime() - before;

                            Assertions.assertThat(a).as(name).isEqualTo(1);
                            Assertions.assertThat(b).as(name).isEqualTo(-1);
                            Assertions.assertThat(c).as(name).isEqualTo(-3);
                            return time;
                        }
                ))
                .build();
    }
}