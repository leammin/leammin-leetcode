package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 172. 阶乘后的零
 * 
 * <p>给定一个整数 <em>n</em>，返回 <em>n</em>! 结果尾数中零的数量。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong> 0
 * <strong>解释:</strong>&nbsp;3! = 6, 尾数中没有零。</pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 5
 * <strong>输出:</strong> 1
 * <strong>解释:</strong>&nbsp;5! = 120, 尾数中有 1 个零.</pre>
 * 
 * <p><strong>说明: </strong>你算法的时间复杂度应为&nbsp;<em>O</em>(log&nbsp;<em>n</em>)<em>&nbsp;</em>。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface FactorialTrailingZeroes {
    int trailingZeroes(int n);

    static Testsuite<FactorialTrailingZeroes> testsuite() {
        return Testsuite.<FactorialTrailingZeroes>builder()
                .add(ExpectedTestcase.of(t -> t.trailingZeroes(3), 0))
                .add(ExpectedTestcase.of(t -> t.trailingZeroes(5), 1))
                .build();
    }


    class Solution implements FactorialTrailingZeroes {

        @Override
        public int trailingZeroes(int n) {
            int ans = 0;
            while (n > 0) {
                n = n / 5;
                ans += n;
            }
            return ans;
        }
    }
}

class FactorialTrailingZeroesTest extends AbstractTest<FactorialTrailingZeroes> {
}
