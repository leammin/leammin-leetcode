package com.leammin.leetcode.easy;

/**
 * 367. 有效的完全平方数
 * 
 * <p>给定一个正整数 <em>num</em>，编写一个函数，如果 <em>num</em> 是一个完全平方数，则返回 True，否则返回 False。</p>
 * 
 * <p><strong>说明：</strong>不要使用任何内置的库函数，如&nbsp; <code>sqrt</code>。</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>16
 * <strong>输出：</strong>True</pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>14
 * <strong>输出：</strong>False
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-18
 */
public interface ValidPerfectSquare {
    boolean isPerfectSquare(int num);

    class Solution implements ValidPerfectSquare {

        @Override
        public boolean isPerfectSquare(int num) {
            int lo = 1;
            int hi = num;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                long s = (long) mid * mid;
                if (s < num) {
                    lo = mid + 1;
                } else if (s > num) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
