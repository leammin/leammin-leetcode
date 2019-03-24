package com.leammin.leetcode.easy;

/**
 * 344. 反转字符串
 * 
 * <div><p>编写一个函数，其作用是将输入的字符串反转过来。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入: </strong>"hello"
 * <strong>输出: </strong>"olleh"
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>"A man, a plan, a canal: Panama"
 * <strong>输出: </strong>"amanaP :lanac a ,nalp a ,nam A"</pre>
 * </div>
 *
 * @date 2018-08-26
 * @author Leammin
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] newChars = new char[len];
        for (int i = 0; i < len; i++) {
            newChars[len - i - 1] = chars[i];
        }

        return new String(newChars);
    }
}
