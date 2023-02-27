package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-30
 */
class YuanQuanZhongZuiHouShengXiaDeShuZiLcofTest extends AbstractTest<YuanQuanZhongZuiHouShengXiaDeShuZiLcof> {
    @Override
    protected Testsuite<YuanQuanZhongZuiHouShengXiaDeShuZiLcof> testsuite() {
        return Testsuite.<YuanQuanZhongZuiHouShengXiaDeShuZiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.lastRemaining(5, 3), 3))
                .add(ExpectedTestcase.of(t -> t.lastRemaining(10, 17), 2))
                .build();
    }
}