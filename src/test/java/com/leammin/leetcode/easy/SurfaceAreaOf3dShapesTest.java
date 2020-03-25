package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-25
 */
class SurfaceAreaOf3dShapesTest extends AbstractTest<SurfaceAreaOf3dShapes> {
    @Override
    protected Testsuite<SurfaceAreaOf3dShapes> testsuite() {
        return Testsuite.<SurfaceAreaOf3dShapes>builder()
                .add(ExpectedTestcase.of(34, t -> t.surfaceArea(new int[][]{{1, 2}, {3, 4}})))
                .add(ExpectedTestcase.of(10, t -> t.surfaceArea(new int[][]{{2}})))
                .add(ExpectedTestcase.of(16, t -> t.surfaceArea(new int[][]{{1, 0}, {0, 2}})))
                .add(ExpectedTestcase.of(32, t -> t.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})))
                .add(ExpectedTestcase.of(46, t -> t.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}})))
                .build();
    }
}