package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leammin
 * @date 2019-04-07
 */
class RangeSumQueryImmutableTest extends AbstractTest<RangeSumQueryImmutable> {

    @Override
    protected Testsuite<RangeSumQueryImmutable> testsuite() {
        return Testsuite.<RangeSumQueryImmutable>builder()
                .add(Testcase.of(
                        clazz-> ClassUtils.newInstance(clazz, new int[]{-2, 0, 3, -5, 2, -1}),
                        solution -> {
                            String name = ClassUtils.getSolutionName(solution);
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
                .build();
    }
}