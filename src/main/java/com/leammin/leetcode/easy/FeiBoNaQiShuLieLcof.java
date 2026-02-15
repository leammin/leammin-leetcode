package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题10- I. 斐波那契数列
 * 
 * <p>写一个函数，输入 <code>n</code> ，求斐波那契（Fibonacci）数列的第 <code>n</code> 项。斐波那契数列的定义如下：</p>
 * 
 * <pre>F(0) = 0,&nbsp; &nbsp;F(1)&nbsp;= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N &gt; 1.</pre>
 * 
 * <p>斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。</p>
 * 
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 2
 * <strong>输出：</strong>1
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 5
 * <strong>输出：</strong>5
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= n &lt;= 100</code></li>
 * </ul>
 * 
 * <p>注意：本题与主站 509 题相同：<a href="https://leetcode-cn.com/problems/fibonacci-number/">https://leetcode-cn.com/problems/fibonacci-number/</a></p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-21
 */
public interface FeiBoNaQiShuLieLcof {
    int fib(int n);

    static Testsuite<FeiBoNaQiShuLieLcof> testsuite() {
        return Testsuite.<FeiBoNaQiShuLieLcof>builder()
                .addExpected(t -> t.fib(2), 1)
                .addExpected(t -> t.fib(5), 5)
                .addExpected(t -> t.fib(36), 14930352)
                .addExpected(t -> t.fib(72), 8390086)
                .build();
    }
    @Execute(cases = -1)


    class Solution implements FeiBoNaQiShuLieLcof {

        @Override
        public int fib(int n) {
            int a = 0;
            int b = 1;
            for (int i = 0; i < n; i++) {
                int t = b;
                b = (a + b) % 1000000007;
                a = t;
            }
            return a;
        }
    }
}

class FeiBoNaQiShuLieLcofTest extends AbstractTest<FeiBoNaQiShuLieLcof> {
}
