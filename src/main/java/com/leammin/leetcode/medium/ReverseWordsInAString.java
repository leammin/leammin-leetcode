package com.leammin.leetcode.medium;

/**
 * 151. 翻转字符串里的单词
 * 
 * <p>给定一个字符串，逐个翻转字符串中的每个单词。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;<code>the sky is blue</code>&quot;
 * <strong>输出:&nbsp;</strong>&quot;<code>blue is sky the</code>&quot;
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot; &nbsp;hello world! &nbsp;&quot;
 * <strong>输出:&nbsp;</strong>&quot;world! hello&quot;
 * <strong>解释: </strong>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;a good &nbsp; example&quot;
 * <strong>输出:&nbsp;</strong>&quot;example good a&quot;
 * <strong>解释: </strong>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>无空格字符构成一个单词。</li>
 * 	<li>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。</li>
 * 	<li>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>进阶：</strong></p>
 * 
 * <p>请选用 C 语言的用户尝试使用&nbsp;<em>O</em>(1) 额外空间复杂度的原地解法。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface ReverseWordsInAString {
    String reverseWords(String s);

    class Solution implements ReverseWordsInAString {

        @Override
        public String reverseWords(String s) {
            int n = s.length();
            char[] res = new char[n];
            int resIndex = n;
            int sIndex = 0;
            while (sIndex < n) {
                while (sIndex < n && s.charAt(sIndex) == ' ') {
                    sIndex++;
                }
                if (sIndex >= n) {
                    break;
                }
                if (n != resIndex) {
                    res[--resIndex] = ' ';
                }
                int wordStart = sIndex;
                while (sIndex < n && s.charAt(sIndex) != ' ') {
                    sIndex++;
                }
                for (int i = sIndex - 1; i >= wordStart ; i--) {
                    res[--resIndex] = s.charAt(i);
                }
            }
            return String.valueOf(res, resIndex, n - resIndex);
        }
    }
}
