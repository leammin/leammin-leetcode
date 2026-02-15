package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题64. 求1+2+…+n
 *
 * <p>求 <code>1+2+...+n</code> ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> n = 3
 * <strong>输出:&nbsp;</strong>6
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> n = 9
 * <strong>输出:&nbsp;</strong>45
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n&nbsp;&lt;= 10000</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-02
 */
public interface Qiu12nLcof {
    int sumNums(int n);

    static Testsuite<Qiu12nLcof> testsuite() {
        return Testsuite.<Qiu12nLcof>builder()
                .add(ExpectedTestcase.of(t -> t.sumNums(3), 6))
                .add(ExpectedTestcase.of(t -> t.sumNums(9), 45))
                .build();
    }


    class Solution implements Qiu12nLcof {

        @Override
        public int sumNums(int n) {
            return ((int) Math.pow(n, 2) + n) >>> 1;
        }
    }

    /**
     * 俄罗斯农民乘法
     */
    class Best implements Qiu12nLcof {
        public int sumNums(int n) {
            int ans = 0, A = n, B = n + 1;
            boolean flag;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            return ans >> 1;
        }
    }
}

class Qiu12nLcofTest extends AbstractTest<Qiu12nLcof> {
}
