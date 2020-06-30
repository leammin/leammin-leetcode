package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-30
 */
class YongLiangGeZhanShiXianDuiLieLcofTest extends AbstractTest<YongLiangGeZhanShiXianDuiLieLcof> {
    @Override
    protected Testsuite<YongLiangGeZhanShiXianDuiLieLcof> testsuite() {
        return Testsuite.<YongLiangGeZhanShiXianDuiLieLcof>builder()
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    queue.appendTail(3);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(3);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(-1);
                    return System.nanoTime() - before;
                }))
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(-1);
                    queue.appendTail(5);
                    queue.appendTail(2);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(5);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(2);
                    return System.nanoTime() - before;
                }))
                .build();
    }
}