package com.leammin.leetcode.easy;

/**
 * 14. 最长公共前缀
 *
 * <div><p>编写一个函数来查找字符串数组中的最长公共前缀。</p>
 *
 * <p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入: </strong>["flower","flow","flight"]
 * <strong>输出:</strong> "fl"
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入: </strong>["dog","racecar","car"]
 * <strong>输出:</strong> ""
 * <strong>解释:</strong> 输入不存在公共前缀。
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <p>所有输入只包含小写字母&nbsp;<code>a-z</code>&nbsp;。</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface LongestCommonPrefix {
    String longestCommonPrefix(String[] strs);

    class Solution implements LongestCommonPrefix {
        @Override
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            String res = "";
            String base = strs[0];
            String basePrefix;
            for (int i = 1; i <= base.length(); i++) {
                basePrefix = base.substring(0, i);
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].startsWith(basePrefix)) {
                        return res;
                    }
                }
                res = basePrefix;
            }
            return res;
        }
    }

    class Solution2 implements LongestCommonPrefix {

        @Override
        public String longestCommonPrefix(String[] strs) {
            int index = 0;
            char c = 0;
            while (true) {
                for (String str : strs) {
                    if (str.length() <= index) {
                        return str.substring(0, index);
                    }
                    if (c == 0) {
                        c = str.charAt(index);
                    } else if (c != str.charAt(index)) {
                        return str.substring(0, index);
                    }
                }
            }
            return "";
        }
    }
}
