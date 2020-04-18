package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Leammin
 * @date 2020-04-05
 */
class LfuCacheTest extends AbstractTest<LfuCache> {
    @Override
    protected Testsuite<LfuCache> testsuite() {
        return Testsuite.<LfuCache>builder()
                .add(Testcase.create(clazz -> {
                    try {
                        return clazz.getDeclaredConstructor(int.class).newInstance(2);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                            | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }, cache -> {
                    long time = System.nanoTime();
                    cache.put(1, 1);
                    cache.put(2, 2);
                    Assertions.assertThat(cache.get(1)).isEqualTo(1);   // 返回 1
                    cache.put(3, 3);                                    // 去除 key 2
                    Assertions.assertThat(cache.get(2)).isEqualTo(-1);  // 返回 -1 (未找到key 2)
                    Assertions.assertThat(cache.get(3)).isEqualTo(3);   // 返回 3
                    cache.put(4, 4);                                    // 去除 key 1
                    Assertions.assertThat(cache.get(1)).isEqualTo(-1);  // 返回 -1 (未找到 key 1)
                    Assertions.assertThat(cache.get(3)).isEqualTo(3);   // 返回 3
                    Assertions.assertThat(cache.get(4)).isEqualTo(4);   // 返回 4
                    return System.nanoTime() - time;
                }))
                .add(Testcase.create(clazz -> {
                    try {
                        return clazz.getDeclaredConstructor(int.class).newInstance(3);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                            | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }, cache -> {
                    long time = System.nanoTime();
                    cache.put(2, 2);
                    cache.put(1, 1);
                    Assertions.assertThat(cache.get(2)).isEqualTo(2);
                    Assertions.assertThat(cache.get(1)).isEqualTo(1);
                    Assertions.assertThat(cache.get(2)).isEqualTo(2);
                    cache.put(3, 3);
                    cache.put(4, 4);
                    Assertions.assertThat(cache.get(3)).isEqualTo(-1);
                    Assertions.assertThat(cache.get(2)).isEqualTo(2);
                    Assertions.assertThat(cache.get(1)).isEqualTo(1);
                    Assertions.assertThat(cache.get(4)).isEqualTo(4);
                    return System.nanoTime() - time;
                }))
                .add(Testcase.create(clazz -> {
                    try {
                        return clazz.getDeclaredConstructor(int.class).newInstance(2);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                            | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }, cache -> {
                    long time = System.nanoTime();
                    cache.put(2, 1);
                    cache.put(1, 1);
                    cache.put(2, 3);
                    cache.put(4, 1);
                    Assertions.assertThat(cache.get(1)).isEqualTo(-1);
                    Assertions.assertThat(cache.get(2)).isEqualTo(3);
                    return System.nanoTime() - time;
                }))
                .add(Testcase.create(clazz -> {
                    try {
                        return clazz.getDeclaredConstructor(int.class).newInstance(3);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                            | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }, cache -> {
                    long time = System.nanoTime();
                    cache.put(1, 1);
                    cache.put(2, 2);
                    cache.put(3, 3);
                    cache.put(4, 4);
                    Assertions.assertThat(cache.get(4)).isEqualTo(4);
                    Assertions.assertThat(cache.get(3)).isEqualTo(3);
                    Assertions.assertThat(cache.get(2)).isEqualTo(2);
                    Assertions.assertThat(cache.get(1)).isEqualTo(-1);
                    cache.put(5, 5);
                    Assertions.assertThat(cache.get(1)).isEqualTo(-1);
                    Assertions.assertThat(cache.get(2)).isEqualTo(2);
                    Assertions.assertThat(cache.get(3)).isEqualTo(3);
                    Assertions.assertThat(cache.get(4)).isEqualTo(-1);
                    Assertions.assertThat(cache.get(5)).isEqualTo(5);
                    return System.nanoTime() - time;
                }))
                .build();
    }
}