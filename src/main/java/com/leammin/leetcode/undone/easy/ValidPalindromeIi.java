package com.leammin.leetcode.undone.easy;

/**
 * 680. 验证回文字符串 Ⅱ
 * 
 * <p>给定一个非空字符串&nbsp;<code>s</code>，<strong>最多</strong>删除一个字符。判断是否能成为回文字符串。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> &quot;aba&quot;
 * <strong>输出:</strong> True
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> &quot;abca&quot;
 * <strong>输出:</strong> True
 * <strong>解释:</strong> 你可以删除c字符。
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ol>
 * 	<li>字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-05-19
 */
public interface ValidPalindromeIi {
    boolean validPalindrome(String s);

    class Solution implements ValidPalindromeIi {

        @Override
        public boolean validPalindrome(String s) {
            return false;
        }
    }
}
