package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 50. Pow(x, n)
 *
 * <p>实现&nbsp;<a href="https://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(<em>x</em>, <em>n</em>)</a>&nbsp;，即计算 x 的 n 次幂函数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> 2.00000, 10
 * <strong>输出:</strong> 1024.00000
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> 2.10000, 3
 * <strong>输出:</strong> 9.26100
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入:</strong> 2.00000, -2
 * <strong>输出:</strong> 0.25000
 * <strong>解释:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li>-100.0 &lt;&nbsp;<em>x</em>&nbsp;&lt; 100.0</li>
 * 	<li><em>n</em>&nbsp;是 32 位有符号整数，其数值范围是&nbsp;[&minus;2<sup>31</sup>,&nbsp;2<sup>31&nbsp;</sup>&minus; 1] 。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2019-08-25
 */
public interface Pow {
    double myPow(double x, int n);

    static Testsuite<Pow> testsuite() {

        return Testsuite.<Pow>builder()
                .add(ExpectedTestcase.of(t->t.myPow(2.00000, 10), 1024.00))
//                .add(ExpectedTestcase.of(9.26100, t->t.myPow(2.10000, 3)))
                .add(ExpectedTestcase.of(t->t.myPow(1, 2147483647), 1.0))
                .add(ExpectedTestcase.of(t->t.myPow(0.00001, 2147483647), 0.0))
                .build();
    }


    class Solution implements Pow {
        @Override
        public double myPow(double x, int n) {
            double res = 1;
            for (int i = n; i != 0; i /= 2) {
                if (i % 2 != 0) {
                    res *= x;
                }
                x *= x;
            }
            return n < 0 ? 1 / res : res;
        }
    }


    /**
     * 如果 n 是偶数
     * pow(x, n) = pow(x, n / 2) * pow(x, n / 2)
     * 如果 n 是奇数
     * pow(x, n) = pow(x, n / 2) * pow(x, n / 2) * n
     */
    class Solution1 implements Pow {
        @Override
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double t = myPow(x, n / 2);
            if (n % 2 == 0) {
                return t * t;
            } else {
                return (n < 0 ? 1 / x : x) * t * t;
            }
        }
    }
}

class PowTest extends AbstractTest<Pow> {
}
