package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-21
 */
class ZhongJianErChaShuLcofTest extends AbstractTest<ZhongJianErChaShuLcof> {
    @Override
    protected Testsuite<ZhongJianErChaShuLcof> testsuite() {
        return Testsuite.<ZhongJianErChaShuLcof>builder()
                .addExpected(t -> t.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}), TreeNode.of(3, 9, 20, null, null, 15, 7))
                .addExpected(t -> t.buildTree(new int[]{-1}, new int[]{-1}), TreeNode.of(-1))
                .build();
    }
}