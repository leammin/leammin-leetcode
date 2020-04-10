package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-04-07
 */
class InsertDeleteGetrandomO1Test extends AbstractTest<InsertDeleteGetrandomO1> {
    @Override
    protected Testsuite<InsertDeleteGetrandomO1> testsuite() {
        return Testsuite.<InsertDeleteGetrandomO1>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    boolean b1 = t.insert(1);
                    boolean b2 = t.remove(2);
                    boolean b3 = t.insert(2);
                    int i1 =  t.getRandom();
                    boolean b4 =  t.remove(1);
                    boolean b5 = t.insert(2);
                    int i2 = t.getRandom();
                    long after = System.nanoTime();

                    Assertions.assertThat(b1).isTrue();
                    Assertions.assertThat(b2).isFalse();
                    Assertions.assertThat(b3).isTrue();
                    Assertions.assertThat(i1).isIn(1,2);
                    Assertions.assertThat(b4).isTrue();
                    Assertions.assertThat(b5).isFalse();
                    Assertions.assertThat(i2).isIn(2);

                    return after - before;
                }))
                .build();
    }
}