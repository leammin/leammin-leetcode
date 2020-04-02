package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.ImplementStackUsingQueues;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-31
 */
class ImplementStackUsingQueuesTest extends AbstractTest<ImplementStackUsingQueues> {
    @Override
    protected Testsuite<ImplementStackUsingQueues> testsuite() {
        return Testsuite.<ImplementStackUsingQueues>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    boolean empty1 = t.empty();
                    t.push(1);
                    t.push(2);
                    t.push(3);
                    int top1 = t.top();
                    int pop1 = t.pop();
                    int pop2 = t.pop();
                    int top2 = t.top();
                    boolean empty2 = t.empty();
                    int pop3 = t.pop();
                    boolean empty3 = t.empty();
                    long after = System.nanoTime();

                    Assertions.assertThat(empty1).isTrue();
                    Assertions.assertThat(empty2).isFalse();
                    Assertions.assertThat(empty3).isTrue();

                    Assertions.assertThat(top1).isEqualTo(3);
                    Assertions.assertThat(top2).isEqualTo(1);

                    Assertions.assertThat(pop1).isEqualTo(3);
                    Assertions.assertThat(pop2).isEqualTo(2);
                    Assertions.assertThat(pop3).isEqualTo(1);

                    return after - before;
                }))
                .build();
    }
}