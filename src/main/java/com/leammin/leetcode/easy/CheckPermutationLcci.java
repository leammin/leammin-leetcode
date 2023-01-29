package com.leammin.leetcode.easy;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 
 * <p>给定两个字符串 <code>s1</code> 和 <code>s2</code>，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bca&quot;
 * <strong>输出:</strong> true 
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bad&quot;
 * <strong>输出:</strong> false
 * </pre>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= len(s1) &lt;= 100 </code></li>
 * 	<li><code>0 &lt;= len(s2) &lt;= 100 </code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2022-09-27
 */
public interface CheckPermutationLcci {
    boolean CheckPermutation(String s1, String s2);

    class Solution implements CheckPermutationLcci {

        @Override
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] count = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                int idx = s1.charAt(i);
                count[idx]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                int idx = s2.charAt(i);
                count[idx]--;
                if (count[idx] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
