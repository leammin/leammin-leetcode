package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 9. 回文数
 * 
 * <p>判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 121
 * <strong>输出:</strong> true
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> -121
 * <strong>输出:</strong> false
 * <strong>解释:</strong> 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * </pre>
 * 
 * <p><strong>示例 3:</strong></p>
 * 
 * <pre><strong>输入:</strong> 10
 * <strong>输出:</strong> false
 * <strong>解释:</strong> 从右向左读, 为 01 。因此它不是一个回文数。
 * </pre>
 * 
 * <p><strong>进阶:</strong></p>
 * 
 * <p>你能不将整数转为字符串来解决这个问题吗？</p>
 * 
 * 
 * @author Leammin
 * @date 2019-08-23
 */
public interface PalindromeNumber {
    boolean isPalindrome(int x);

    static Testsuite<PalindromeNumber> testsuite() {
        return Testsuite.<PalindromeNumber>builder()
                .add(ExpectedTestcase.of(t-> t.isPalindrome(101), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(1), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(10), false))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(1122332211), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(-121), false))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(-1), false))
                .build();
    }


    class Solution implements PalindromeNumber {
        @Override
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int t = x;
            int y = 0;
            while (t != 0) {
                y = y * 10 + t % 10;
                t /= 10;
            }
            return x == y;
        }
    }

}

class PalindromeNumberTest extends AbstractTest<PalindromeNumber> {
}
