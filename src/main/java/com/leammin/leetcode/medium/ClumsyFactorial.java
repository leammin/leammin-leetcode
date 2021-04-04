package com.leammin.leetcode.medium;

/**
 * 1006. 笨阶乘
 * 
 * <p>通常，正整数 <code>n</code> 的阶乘是所有小于或等于 <code>n</code> 的正整数的乘积。例如，<code>factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1</code>。</p>
 * 
 * <p>相反，我们设计了一个笨阶乘 <code>clumsy</code>：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。</p>
 * 
 * <p>例如，<code>clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1</code>。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。</p>
 * 
 * <p>另外，我们使用的除法是地板除法（<em>floor division</em>），所以&nbsp;<code>10 * 9 / 8</code>&nbsp;等于&nbsp;<code>11</code>。这保证结果是一个整数。</p>
 * 
 * <p>实现上面定义的笨函数：给定一个整数 <code>N</code>，它返回 <code>N</code> 的笨阶乘。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>4
 * <strong>输出：</strong>7
 * <strong>解释：</strong>7 = 4 * 3 / 2 + 1
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>10
 * <strong>输出：</strong>12
 * <strong>解释：</strong>12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= N &lt;= 10000</code></li>
 * 	<li><code>-2^31 &lt;= answer &lt;= 2^31 - 1</code>&nbsp; （答案保证符合 32 位整数。）</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-04-04
 */
public interface ClumsyFactorial {
    int clumsy(int N);

    class Solution implements ClumsyFactorial {

        @Override
        public int clumsy(int N) {
            if (N <= 2) {
                return N;
            }
            if (N == 3) {
                return 6;
            }
            if (N == 4) {
                return 7;
            }
            int m = N / 4 - 1;
            int d = N % 4;
            // 前 4 项
            int head = 2 * N - 2;
            // 中间 4*m 项
            int mid = -4 * m - 2 / (N - 4 * m - 2);
            // 最后 d 项
            int tail = d == 3 ? -6 : -d;
            return head + mid + tail;
        }
    }

    class Solution2 implements ClumsyFactorial {

        @Override
        public int clumsy(int N) {
            if (N <= 2) {
                return N;
            }
            if (N == 3) {
                return 6;
            }
            if (N == 4) {
                return 7;
            }
            int m = (N - 3) / 4;
            int d = (N - 3) % 4;
            // 前 3 项
            int head = N + 1;
            // 中间 4*m 项
            int mid = - 2/ (N - 4 * m - 2);
            // 最后 d 项
            int tail = d == 0 ? 0 : 1;
            return head + mid + tail;
        }
    }
}
