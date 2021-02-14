package com.leammin.leetcode.easy;

/**
 * 231. 2的幂
 * 
 * <p>给定一个整数，编写一个函数来判断它是否是 2 的幂次方。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1
 * <strong>输出:</strong> true
 * <strong>解释: </strong>2<sup>0</sup>&nbsp;= 1</pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 16
 * <strong>输出:</strong> true
 * <strong>解释: </strong>2<sup>4</sup>&nbsp;= 16</pre>
 * 
 * <p><strong>示例 3:</strong></p>
 * 
 * <pre><strong>输入:</strong> 218
 * <strong>输出:</strong> false</pre>
 * 
 * 
 * @author Leammin
 * @date 2021-02-13
 */
public interface PowerOfTwo {
    boolean isPowerOfTwo(int n);

    class Solution implements PowerOfTwo {

        @Override
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            int x = n;
            int d = 0;
            while (x != 1) {
                x >>>= 1;
                d++;
            }
            return n == (1 << d);
        }
    }

    class Solution2 implements PowerOfTwo {

        @Override
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
