package com.leammin.leetcode.easy;

/**
 * 326. 3的幂
 *
 * <div><p>给定一个整数，写一个函数来判断它是否是 3&nbsp;的幂次方。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> 27
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> 0
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入:</strong> 9
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 4:</strong></p>
 *
 * <pre><strong>输入:</strong> 45
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>进阶：</strong><br>
 * 你能不使用循环或者递归来完成本题吗？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-27
 */
public interface PowerOfThree {
    boolean isPowerOfThree(int n);

    class Solution implements PowerOfThree {
        @Override
        public boolean isPowerOfThree(int n) {
            double a = Math.log(n) / Math.log(3);
            return Math.abs(Math.round(a) - a) < 1e-10;
        }
    }
}
