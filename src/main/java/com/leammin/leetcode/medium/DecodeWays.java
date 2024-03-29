package com.leammin.leetcode.medium;

/**
 * 91. 解码方法
 * 
 * <p>一条包含字母&nbsp;<code>A-Z</code> 的消息通过以下方式进行了编码：</p>
 * 
 * <pre>&#39;A&#39; -&gt; 1
 * &#39;B&#39; -&gt; 2
 * ...
 * &#39;Z&#39; -&gt; 26
 * </pre>
 * 
 * <p>给定一个只包含数字的<strong>非空</strong>字符串，请计算解码方法的总数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;12&quot;
 * <strong>输出:</strong> 2
 * <strong>解释:</strong>&nbsp;它可以解码为 &quot;AB&quot;（1 2）或者 &quot;L&quot;（12）。
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;226&quot;
 * <strong>输出:</strong> 3
 * <strong>解释:</strong>&nbsp;它可以解码为 &quot;BZ&quot; (2 26), &quot;VF&quot; (22 6), 或者 &quot;BBF&quot; (2 2 6) 。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-21
 */
public interface DecodeWays {
    int numDecodings(String s);

    class Solution implements DecodeWays {

        @Override
        public int numDecodings(String s) {
            int ll = 0;
            int l = 1;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                if (num == 0) {
                    int ln;
                    if (i == 0 || (ln = s.charAt(i - 1) - '0') > 2 || ln == 0) {
                        return 0;
                    }
                    l = ll;
                    continue;
                }
                int cur = l;
                int ln;
                if (i > 0 && (ln = s.charAt(i - 1) - '0') > 0 && ln * 10 + num <= 26) {
                    cur += ll;
                }
                ll = l;
                l = cur;
            }
            return l;
        }

    }
}
