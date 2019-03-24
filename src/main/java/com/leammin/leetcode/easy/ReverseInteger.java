package com.leammin.leetcode.easy;

/**
 * 7. 反转整数
 *
 * <div><p>给定一个 32 位有符号整数，将整数中的数字进行反转。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> 123
 * <strong>输出:</strong> 321
 * </pre>
 *
 * <p><strong>&nbsp;示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> -123
 * <strong>输出:</strong> -321
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入:</strong> 120
 * <strong>输出:</strong> 21
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <p>假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>− 1]。根据这个假设，如果反转后的整数溢出，则返回 0。</p>
 * </div>
 *
 * @date 2018-09-02
 * @author Leammin
 */
public class ReverseInteger {
    public int reverse(int x) {

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (x < 0) {
            sb.deleteCharAt(0);
        }
        sb = sb.reverse();
        Long res = Long.valueOf(sb.toString());
        if (x < 0) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return res.intValue();
        }
    }

    public static int reverse2(int x) {
        int[] each = new int[10];
        int digits = 0;
        int quotient = 0;
        boolean isNegative = x < 0;
        while (x != 0) {
            quotient = x / 10;
            each[digits++] = isNegative ? quotient * 10 - x : x - quotient * 10;
            x = quotient;
        }
        long res = 0;
        int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        for (int i = 0; i < digits; i++) {
            res = res + (long) each[digits - i - 1] * ten[i];
        }
        if (isNegative) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static int reverse3(int x) {
        int quotient = 0;
        int remainder = 0;
        long res = 0;
        boolean isNegative = x < 0;
        while (x != 0) {
            quotient = x / 10;
            remainder = isNegative ? quotient * 10 - x : x - quotient * 10;
            x = quotient;
            res = res * 10 + remainder;
        }
        if (isNegative) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse3(-146));
    }
}
