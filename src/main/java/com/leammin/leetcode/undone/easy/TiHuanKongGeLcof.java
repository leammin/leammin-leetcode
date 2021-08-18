package com.leammin.leetcode.undone.easy;

/**
 * 面试题05. 替换空格
 * 
 * <p>请实现一个函数，把字符串 <code>s</code> 中的每个空格替换成&quot;%20&quot;。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>s = &quot;We are happy.&quot;
 * <strong>输出：</strong>&quot;We%20are%20happy.&quot;</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <p><code>0 &lt;= s 的长度 &lt;= 10000</code></p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-18
 */
public interface TiHuanKongGeLcof {
    String replaceSpace(String s);

    class Solution implements TiHuanKongGeLcof {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
