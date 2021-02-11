package com.leammin.leetcode.medium;

/**
 * 567. 字符串的排列
 * 
 * <p>给定两个字符串&nbsp;<strong>s1</strong>&nbsp;和&nbsp;<strong>s2</strong>，写一个函数来判断 <strong>s2</strong> 是否包含 <strong>s1&nbsp;</strong>的排列。</p>
 * 
 * <p>换句话说，第一个字符串的排列之一是第二个字符串的子串。</p>
 * 
 * <p><strong>示例1:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>s1 = &quot;ab&quot; s2 = &quot;eidbaooo&quot;
 * <strong>输出: </strong>True
 * <strong>解释:</strong> s2 包含 s1 的排列之一 (&quot;ba&quot;).
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例2:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>s1= &quot;ab&quot; s2 = &quot;eidboaoo&quot;
 * <strong>输出:</strong> False
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>注意：</strong></p>
 * 
 * <ol>
 * 	<li>输入的字符串只包含小写字母</li>
 * 	<li>两个字符串的长度都在 [1, 10,000] 之间</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-02-10
 */
public interface PermutationInString {
    boolean checkInclusion(String s1, String s2);

    class Solution implements PermutationInString {

        @Override
        public boolean checkInclusion(String s1, String s2) {
            char[] count = new char[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
            }
            char[] subcount = new char[26];
            int l = 0, r = 0;
            while (r < s2.length()) {
                int i = s2.charAt(r) - 'a';
                if (count[i] == 0) {
                    l = r + 1;
                    subcount = new char[26];
                } else {
                    subcount[i]++;
                }
                r++;
                if (r - l == s1.length()) {
                    boolean b = true;
                    for (int j = 0; j < count.length; j++) {
                        if (count[j] != subcount[j]) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        return true;
                    } else {
                        subcount[s2.charAt(l++) - 'a']--;
                    }
                }
            }
            return false;
        }
    }
}
