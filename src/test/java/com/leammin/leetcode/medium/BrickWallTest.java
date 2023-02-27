package com.leammin.leetcode.medium;

import java.util.List;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-06
 */
class BrickWallTest extends AbstractTest<BrickWall> {
    @Override
    protected Testsuite<BrickWall> testsuite() {
        return Testsuite.<BrickWall>builder()
            .addExpected(t -> t.leastBricks(
                List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 4), List.of(3, 1, 2),
                    List.of(1, 3, 1, 1))), 2)
            .build();
    }
}