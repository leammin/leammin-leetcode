package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-05-25
 */
class LruCacheTest extends AbstractTest<LruCache> {
    @Override
    protected Testsuite<LruCache> testsuite() {
        return Testsuite.<LruCache>builder()
                .add(Testcase.create(
                        c -> ClassUtils.newInstance(c, 2),
                        t -> {
                            long before = System.nanoTime();
                            t.put(1,1);
                            t.put(2,2);
                            int v1 = t.get(1);
                            t.put(3,3);
                            int v2 = t.get(2);
                            t.put(4,4);
                            int v3 = t.get(1);
                            int v4 = t.get(3);
                            int v5 = t.get(4);
                            long after = System.nanoTime();

                            Assertions.assertThat(v1).isEqualTo(1);
                            Assertions.assertThat(v2).isEqualTo(-1);
                            Assertions.assertThat(v3).isEqualTo(-1);
                            Assertions.assertThat(v4).isEqualTo(3);
                            Assertions.assertThat(v5).isEqualTo(4);

                            return after - before;
                        }
                ))
                .add(Testcase.create(
                        c -> ClassUtils.newInstance(c, 2),
                        t -> {
                            long before = System.nanoTime();
                            int v1 = t.get(2);
                            t.put(2,6);
                            int v2 = t.get(1);
                            t.put(1,5);
                            t.put(1,2);
                            int v3 = t.get(1);
                            int v4 = t.get(2);
                            long after = System.nanoTime();

                            Assertions.assertThat(v1).isEqualTo(-1);
                            Assertions.assertThat(v2).isEqualTo(-1);
                            Assertions.assertThat(v3).isEqualTo(2);
                            Assertions.assertThat(v4).isEqualTo(6);

                            return after - before;
                        }
                ))
                .add(Testcase.create(
                        c -> ClassUtils.newInstance(c, 2),
                        t -> {
                            long before = System.nanoTime();
                            t.put(2,1);
                            t.put(1,1);
                            t.put(2,3);
                            t.put(4,1);
                            int v1 = t.get(1);
                            int v2 = t.get(2);
                            long after = System.nanoTime();

                            Assertions.assertThat(v1).isEqualTo(-1);
                            Assertions.assertThat(v2).isEqualTo(3);

                            return after - before;
                        }
                ))
                .build();
    }
}