package com.leammin.leetcode.easy;

import java.util.Arrays;

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
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int[] p = new int[]{1,3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969,14348907,43046721,129140163,387420489,1162261467};
        return Arrays.binarySearch(p, n) >= 0;
    }

    public boolean isPowerOfThree2(int n) {
        double a = Math.log(n) / Math.log(3);
        return Math.abs(Math.round(a) - a) < 1e-10;
    }
    
    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(3));
    }
}
