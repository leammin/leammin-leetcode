package com.leammin.leetcode.todo.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/">1680. 连接连续二进制数字</a>
 *
 * <p>给你一个整数 <code>n</code> ，请你将 <code>1</code> 到 <code>n</code> 的二进制表示连接起来，并返回连接结果对应的 <strong>十进制</strong> 数字对 <code>10<sup>9</sup> + 7</code> 取余的结果。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><b>输入：</b>n = 1
 * <b>输出：</b>1
 * <strong>解释：</strong>二进制的 "1" 对应着十进制的 1 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>n = 3
 * <b>输出：</b>27
 * <strong>解释：</strong>二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><b>输入：</b>n = 12
 * <b>输出：</b>505379714
 * <b>解释：</b>连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 10<sup>9</sup> + 7 取余后，结果为 505379714 。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2026-02-28
 */
public interface ConcatenationOfConsecutiveBinaryNumbers {
    int concatenatedBinary(int n);

    static Testsuite<ConcatenationOfConsecutiveBinaryNumbers> testsuite() {
        return Testsuite.<ConcatenationOfConsecutiveBinaryNumbers>builder()
        .addExpected(t -> t.concatenatedBinary(1), 1)
        .addExpected(t -> t.concatenatedBinary(3), 27)
        .addExpected(t -> t.concatenatedBinary(12), 505379714)
        .build();
    }

    class Solution implements ConcatenationOfConsecutiveBinaryNumbers {

        public int concatenatedBinary(int n) {
            int mod = 1000000007;
            int result = n % mod;
            int curBits = 0;
            while ((n >> curBits) > 0) {
                curBits++;
            }
            int sumBits = curBits;
            for (int i = n-1; i >= 1; i--) {
                int x = i;  // x =  (i << sumBits) % mod
                for(int j = 0; j < sumBits; j++) {
                    x = (x << 1) % mod;
                }
                result = (x + result) % mod;
                if (i >> (curBits - 1) == 0) {
                    curBits--;
                }
                sumBits += curBits;
            }
            return result;
        }
    }
    
    
    class Solution2 implements ConcatenationOfConsecutiveBinaryNumbers {

        public int concatenatedBinary(int n) {
            int mod = 1000000007;
            long result = n % mod;
            int curBits = 0;
            while ((n >> curBits) > 0) {
                curBits++;
            }
            long factor = 1;
            for (int m = n-1; m >= 1; m--) {
                factor = (((1 << curBits) % mod) * factor) % mod;
                long x = (factor * m) % mod;
                result = (x + result) % mod;
                if (m >> (curBits - 1) == 0) {
                    curBits--;
                }
            }
            return (int) result;
        }
    }
}

class ConcatenationOfConsecutiveBinaryNumbersTest
    extends AbstractTest<ConcatenationOfConsecutiveBinaryNumbers> {}
