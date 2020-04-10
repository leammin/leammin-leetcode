package com.leammin.leetcode.easy;

/**
 * 171. Excel表列序号
 * 
 * <p>给定一个Excel表格中的列名称，返回其相应的列序号。</p>
 * 
 * <p>例如，</p>
 * 
 * <pre>    A -&gt; 1
 *     B -&gt; 2
 *     C -&gt; 3
 *     ...
 *     Z -&gt; 26
 *     AA -&gt; 27
 *     AB -&gt; 28 
 *     ...
 * </pre>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;A&quot;
 * <strong>输出:</strong> 1
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入: </strong>&quot;AB&quot;
 * <strong>输出:</strong> 28
 * </pre>
 * 
 * <p><strong>示例&nbsp;3:</strong></p>
 * 
 * <pre><strong>输入: </strong>&quot;ZY&quot;
 * <strong>输出:</strong> 701</pre>
 * 
 * <p><strong>致谢：</strong><br>
 * 特别感谢&nbsp;<a href="http://leetcode.com/discuss/user/ts">@ts</a>&nbsp;添加此问题并创建所有测试用例。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface ExcelSheetColumnNumber {
    int titleToNumber(String s);

    class Solution implements ExcelSheetColumnNumber {

        @Override
        public int titleToNumber(String s) {
            int ans = 0;
            int d = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                ans += (c - 'A' + 1) * d;
                d *= 26;
            }
            return ans;
        }
    }
}
