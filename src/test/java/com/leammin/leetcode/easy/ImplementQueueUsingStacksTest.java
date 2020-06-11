package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-11
 */
class ImplementQueueUsingStacksTest extends AbstractTest<ImplementQueueUsingStacks> {
    @Override
    protected Testsuite<ImplementQueueUsingStacks> testsuite() {
        return Testsuite.<ImplementQueueUsingStacks>builder()
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    queue.push(1);
                    queue.push(2);
                    Assertions.assertThat(queue.peek()).isEqualTo(1);
                    Assertions.assertThat(queue.pop()).isEqualTo(1);
                    Assertions.assertThat(queue.empty()).isFalse();
                    return System.nanoTime() - before;
                }))
                .build();
    }
}