package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-01
 */
class DesignCircularQueueTest extends AbstractTest<DesignCircularQueue> {
    @Override
    protected Testsuite<DesignCircularQueue> testsuite() {
        return Testsuite.<DesignCircularQueue>builder()
                .add(Testcase.create(clazz -> ClassUtils.newInstance(clazz, 3), t -> {
                    long time = System.nanoTime();
                    Assertions.assertThat(t.enQueue(1)).isTrue();
                    Assertions.assertThat(t.enQueue(2)).isTrue();
                    Assertions.assertThat(t.enQueue(3)).isTrue();
                    Assertions.assertThat(t.enQueue(4)).isFalse();
                    Assertions.assertThat(t.Rear()).isEqualTo(3);
                    Assertions.assertThat(t.isFull()).isTrue();
                    Assertions.assertThat(t.deQueue()).isTrue();
                    Assertions.assertThat(t.enQueue(4)).isTrue();
                    Assertions.assertThat(t.Rear()).isEqualTo(4);
                    return System.nanoTime() - time;
                }))
                .build();
    }
}