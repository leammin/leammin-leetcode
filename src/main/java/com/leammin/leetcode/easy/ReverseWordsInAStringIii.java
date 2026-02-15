package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 557. 反转字符串中的单词 III
 * 
 * <p>给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre>
 * 输入: &quot;Let&#39;s take LeetCode contest&quot;
 * 输出: &quot;s&#39;teL ekat edoCteeL tsetnoc&quot;<strong><strong><strong>&nbsp;</strong></strong></strong>
 * </pre>
 * 
 * <p><strong><strong><strong><strong>注意：</strong></strong></strong></strong>在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-15
 */
public interface ReverseWordsInAStringIii {
    String reverseWords(String s);

    static Testsuite<ReverseWordsInAStringIii> testsuite() {
        return Testsuite.<ReverseWordsInAStringIii>builder()
                .add(ExpectedTestcase.of(t -> t.reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc"))
                .build();
    }


    class Solution implements ReverseWordsInAStringIii {

        @Override
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder(s.length());
            int last = -1;
            for (int i = 0; i <= s.length(); i++) {
                if (i == s.length() || s.charAt(i) == ' ') {
                    for (int j = i - 1; j > last; j--) {
                        res.append(s.charAt(j));
                    }
                    last = i;
                    if (i != s.length()) {
                        res.append(' ');
                    }
                }
            }
            return res.toString();
        }
    }
}

class ReverseWordsInAStringIiiTest extends AbstractTest<ReverseWordsInAStringIii> {
}
