package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-14
 */
class TaskSchedulerTest extends AbstractTest<TaskScheduler> {
    @Override
    protected Testsuite<TaskScheduler> testsuite() {
        return Testsuite.<TaskScheduler>builder()
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2), 8))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50), 104))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A','B','C','D','E','A','B','C','D','E'}, 4), 10))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A','A','A','B','B','B'}, 0), 6))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2), 16))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 1), 12))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A'}, 2), 1))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A','B','A'}, 2), 4))
                .add(ExpectedTestcase.of(t -> t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B','B', 'C', 'C', 'D'}, 3), 10))
                .build();
    }
}