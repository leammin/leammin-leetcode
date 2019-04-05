package com.leammin.leetcode.easy;

/**
 * 191. 位1的个数
 *
 * <div><p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’&nbsp;的个数（也被称为<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F" target="_blank">汉明重量</a>）。</p>
 *
 * <p><strong>示例&nbsp;:</strong></p>
 *
 * <pre><strong>输入:</strong> 11
 * <strong>输出:</strong> 3
 * <strong>解释: </strong>整数 11 的二进制表示为 <code><strong>00000000000000000000000000001011</strong></code></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> 128
 * <strong>输出:</strong> 1
 * <strong>解释: </strong>整数 128 的二进制表示为 <strong>00000000000000000000000010000000</strong></pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-01
 */
public interface NumberOfOneBits {
    /**
     * you need to treat n as an unsigned value
     *
     * @param n
     * @return
     */
    int hammingWeight(int n);

    class Solution implements NumberOfOneBits {
        @Override
        public int hammingWeight(int n) {
            int res = 0;
            int c = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & c) != 0) {
                    res++;
                }
                c = c << 1;
            }
            return res;
        }
    }

}
