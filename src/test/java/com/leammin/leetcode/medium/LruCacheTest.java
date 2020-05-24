package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.LruCache;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-25
 */
class LruCacheTest extends AbstractTest<LruCache> {
    @Override
    protected Testsuite<LruCache> testsuite() {
        return Testsuite.<LruCache>builder()
                .build();
    }
}