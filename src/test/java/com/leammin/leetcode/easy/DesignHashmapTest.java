package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class DesignHashmapTest extends AbstractTest<DesignHashmap> {
    @Override
    protected Testsuite<DesignHashmap> testsuite() {
        return Testsuite.<DesignHashmap>builder()
                .add(Testcase.of(t -> {
                    long b = System.nanoTime();
                    t.put(1, 1);
                    t.put(2, 2);
                    int r1 = t.get(1);// 返回 1
                    int r2 = t.get(3);            // 返回 -1 (未找到)
                    t.put(2, 1);         // 更新已有的值
                    int r3 = t.get(2);            // 返回 1
                    t.remove(2);         // 删除键为2的数据
                    int r4 = t.get(2);            // 返回 -1 (未找到)
                    long a = System.nanoTime();
                    Assertions.assertThat(r1).isEqualTo(1);
                    Assertions.assertThat(r2).isEqualTo(-1);
                    Assertions.assertThat(r3).isEqualTo(1);
                    Assertions.assertThat(r4).isEqualTo(-1);
                    return a - b;
                }))
                .build();
    }
}