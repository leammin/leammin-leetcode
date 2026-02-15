package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 409. 最长回文串
 * 
 * <p>给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。</p>
 * 
 * <p>在构造过程中，请注意区分大小写。比如&nbsp;<code>&quot;Aa&quot;</code>&nbsp;不能当做一个回文字符串。</p>
 * 
 * <p><strong>注意:</strong><br />
 * 假设字符串的长度不会超过 1010。</p>
 * 
 * <p><strong>示例 1: </strong></p>
 * 
 * <pre>
 * 输入:
 * &quot;abccccdd&quot;
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是&quot;dccaccd&quot;, 它的长度是 7。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-03-19
 */
public interface LongestPalindrome {
    int longestPalindrome(String s);

    static Testsuite<LongestPalindrome> testsuite() {
        return Testsuite.<LongestPalindrome>builder()
                .add(ExpectedTestcase.of(t -> t.longestPalindrome("abccccdd"), 7))
                .build();
    }


    class Solution implements LongestPalindrome {

        @Override
        public int longestPalindrome(String s) {
            int ans = 0;
            int[] cache = new int[52];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c >= 'a' ? c - 'a' + 26 : c - 'A';
                if (cache[index] > 0) {
                    ans += 2;
                    cache[index]--;
                } else {
                    cache[index]++;
                }
            }
            return ans < s.length() ? ans + 1 : ans;
        }
    }
}

class LongestPalindromeTest extends AbstractTest<LongestPalindrome> {
}
