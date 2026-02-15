package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 <code>n</code>&nbsp;级的台阶总共有多少种跳法。</p>
 * 
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 2
 * <strong>输出：</strong>2
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 7
 * <strong>输出：</strong>21
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= n &lt;= 100</code></li>
 * </ul>
 * 
 * <p>注意：本题与主站 509 题相同：<a href="https://leetcode-cn.com/problems/fibonacci-number/">https://leetcode-cn.com/problems/fibonacci-number/</a></p>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-22
 */
public interface QingWaTiaoTaiJieWenTiLcof {
    int numWays(int n);

    static Testsuite<QingWaTiaoTaiJieWenTiLcof> testsuite() {
        return Testsuite.<QingWaTiaoTaiJieWenTiLcof>builder()
                .addExpected(t -> t.numWays(2), 2)
                .addExpected(t -> t.numWays(7), 21)
                .build();
    }


    class Solution implements QingWaTiaoTaiJieWenTiLcof {

        @Override
        public int numWays(int n) {
            int a = 0;
            int b = 1;
            for (int i = 0; i < n; i++) {
                int t = b;
                b = (a + b) % 1000000007;
                a = t;
            }
            return b;
        }
    }
}

class QingWaTiaoTaiJieWenTiLcofTest extends AbstractTest<QingWaTiaoTaiJieWenTiLcof> {
}
