package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-07
 */
class DuiLieDeZuiDaZhiLcofTest extends AbstractTest<DuiLieDeZuiDaZhiLcof> {
    @Override
    protected Testsuite<DuiLieDeZuiDaZhiLcof> testsuite() {
        return Testsuite.<DuiLieDeZuiDaZhiLcof>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    t.push_back(1);
                    t.push_back(2);
                    int r1 = t.max_value();
                    int r2 = t.pop_front();
                    int r3 = t.max_value();
                    long after = System.nanoTime();

                    Assertions.assertThat(r1).isEqualTo(2);
                    Assertions.assertThat(r2).isEqualTo(1);
                    Assertions.assertThat(r3).isEqualTo(2);
                    return after - before;
                }))
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    int r1 = t.pop_front();
                    int r2 = t.max_value();
                    long after = System.nanoTime();

                    Assertions.assertThat(r1).isEqualTo(-1);
                    Assertions.assertThat(r2).isEqualTo(-1);
                    return after - before;
                }))
                .build();
    }
}