package com.leammin.leetcode.easy;

/**
 * 58. 最后一个单词的长度
 * 
 * <p>给定一个仅包含大小写字母和空格&nbsp;<code>&#39; &#39;</code>&nbsp;的字符串，返回其最后一个单词的长度。</p>
 * 
 * <p>如果不存在最后一个单词，请返回 0&nbsp;。</p>
 * 
 * <p><strong>说明：</strong>一个单词是指由字母组成，但不包含任何空格的字符串。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;Hello World&quot;
 * <strong>输出:</strong> 5
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-08-10
 */
public interface LengthOfLastWord {
    int lengthOfLastWord(String s);

    class Solution implements LengthOfLastWord {

        @Override
        public int lengthOfLastWord(String s) {
            int size = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    if (size == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
                size++;
            }
            return size;
        }
    }
}
