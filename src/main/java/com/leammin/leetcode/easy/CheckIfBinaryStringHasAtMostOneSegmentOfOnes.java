package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/">1784. 检查二进制字符串字段</a>
 * 
 * <p>给你一个二进制字符串 <code>s</code> ，该字符串 <strong>不含前导零</strong> 。</p>
 * 
 * <p>如果 <code>s</code> 包含 <strong>零个或一个由连续的 <code>'1'</code> 组成的字段</strong> ，返回 <code>true</code>​​​ 。否则，返回 <code>false</code> 。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>s = "1001"
 * <strong>输出：</strong>false
 * <strong>解释：</strong>由连续若干个&nbsp;<code>'1'</code> 组成的字段数量为 2，返回 false
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>s = "110"
 * <strong>输出：</strong>true</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s[i]</code>​​​​ 为 <code>'0'</code> 或 <code>'1'</code></li>
 * 	<li><code>s[0]</code> 为 <code>'1'</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2026-03-07
 */
public interface CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    boolean checkOnesSegment(String s);

    static Testsuite<CheckIfBinaryStringHasAtMostOneSegmentOfOnes> testsuite() {
        return Testsuite.<CheckIfBinaryStringHasAtMostOneSegmentOfOnes>builder()
                .addExpected(t -> t.checkOnesSegment("1001"), false)
                .addExpected(t -> t.checkOnesSegment("110"), true)
                .build();
    }

    class Solution implements CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

        @Override
        public boolean checkOnesSegment(String s) {
            boolean a = false;
            boolean b = false;
            for (int i = 0; i < s.length(); i++) {
                if (!a && s.charAt(i) == '1') {
                    a = true;
                } else if(a && !b && s.charAt(i) == '0') {
                    b =true;
                } else if (a && b && s.charAt(i) == '1') {
                    return false;
                }
            }
            return true;
        }
    }
}

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest extends AbstractTest<CheckIfBinaryStringHasAtMostOneSegmentOfOnes> {
}
