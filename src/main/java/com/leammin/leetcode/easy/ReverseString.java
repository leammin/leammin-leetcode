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
 * @author Leammin
 * @date 2018-08-26
 */
public interface ReverseString {
    void reverseString(char[] s);

    class Solution implements ReverseString {
        @Override
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }
    }

}
