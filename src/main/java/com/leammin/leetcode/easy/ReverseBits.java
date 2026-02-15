package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 190. 颠倒二进制位
 *
 * <div><p>颠倒给定的 32 位无符号整数的二进制位。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 43261596
 * <strong>输出:</strong> 964176192
 * <strong>解释: </strong>43261596 的二进制表示形式为 <strong>00000010100101000001111010011100 </strong>，
 * &nbsp;    返回 964176192，其二进制表示形式为 <strong>00111001011110000010100101000000 </strong>。</pre>
 *
 * <p><strong>进阶</strong>:<br>
 * 如果多次调用这个函数，你将如何优化你的算法？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-15
 */
public interface ReverseBits {
    int reverseBits(int n);

    static Testsuite<ReverseBits> testsuite() {
        return Testsuite.<ReverseBits>builder()
            // 00000010100101000001111010011100 -> 00111001011110000010100101000000
            .addExpected(t -> t.reverseBits(43261596), 964176192)
            // 11111111111111111111111111111101 -> 10111111111111111111111111111111
            .addExpected(
                t -> t.reverseBits(0b11111111111111111111111111111101),
                0b10111111111111111111111111111111
            )
            .build();
    }

    class Solution implements ReverseBits {

        @Override
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result = (result << 1);
                if (n != 0) {
                    result += (n & 1);
                    n = n >>> 1;
                }
            }
            return result;
        }
    }

    class Solution2 implements ReverseBits {
        @Override
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int x = 1 << i;
                if ((n & x) != 0) {
                    result = (result | (1 << (31 - i)));
                }
            } 
            return result;
        }
    }
}

class ReverseBitsTest extends AbstractTest<ReverseBits> {}
