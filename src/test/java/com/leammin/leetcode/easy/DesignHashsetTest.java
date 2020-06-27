package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.DesignHashset;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class DesignHashsetTest extends AbstractTest<DesignHashset> {
    @Override
    protected Testsuite<DesignHashset> testsuite() {
        return Testsuite.<DesignHashset>builder()
                .add(Testcase.of(t -> {
                    long b = System.nanoTime();
                    t.add(1);
                    t.add(2);
                    boolean r1 = t.contains(1);// 返回 true
                    boolean r2 = t.contains(3);// 返回 false (未找到)
                    t.add(2);
                    boolean r3 = t.contains(2);// 返回 true
                    t.remove(2);
                    boolean r4 = t.contains(2);// 返回  false (已经被删除)
                    long a = System.nanoTime();
                    Assertions.assertThat(r1).isTrue();
                    Assertions.assertThat(r2).isFalse();
                    Assertions.assertThat(r3).isTrue();
                    Assertions.assertThat(r4).isFalse();
                    return a - b;
                }))
                .build();
    }
}