package com.leammin.leetcode.medium;

/**
 * 1208. 尽可能使字符串相等
 * 
 * <p>给你两个长度相同的字符串，<code>s</code> 和 <code>t</code>。</p>
 * 
 * <p>将 <code>s</code>&nbsp;中的第&nbsp;<code>i</code>&nbsp;个字符变到&nbsp;<code>t</code>&nbsp;中的第 <code>i</code> 个字符需要&nbsp;<code>|s[i] - t[i]|</code>&nbsp;的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。</p>
 * 
 * <p>用于变更字符串的最大预算是&nbsp;<code>maxCost</code>。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。</p>
 * 
 * <p>如果你可以将 <code>s</code> 的子字符串转化为它在 <code>t</code> 中对应的子字符串，则返回可以转化的最大长度。</p>
 * 
 * <p>如果 <code>s</code> 中没有子字符串可以转化成 <code>t</code> 中对应的子字符串，则返回 <code>0</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>s = &quot;abcd&quot;, t = &quot;bcdf&quot;, cost = 3
 * <strong>输出：</strong>3
 * <strong>解释：</strong>s<strong> </strong>中的<strong> </strong>&quot;abc&quot; 可以变为 &quot;bcd&quot;。开销为 3，所以最大长度为 3。</pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>s = &quot;abcd&quot;, t = &quot;cdef&quot;, cost = 3
 * <strong>输出：</strong>1
 * <strong>解释：</strong>s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为<code> 1。</code>
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>s = &quot;abcd&quot;, t = &quot;acde&quot;, cost = 0
 * <strong>输出：</strong>1
 * <strong>解释：</strong>你无法作出任何改动，所以最大长度为 1。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length, t.length &lt;= 10^5</code></li>
 * 	<li><code>0 &lt;= maxCost &lt;= 10^6</code></li>
 * 	<li><code>s</code> 和&nbsp;<code>t</code>&nbsp;都只含小写英文字母。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-05
 */
public interface GetEqualSubstringsWithinBudget {
    int equalSubstring(String s, String t, int maxCost);

    class Solution implements GetEqualSubstringsWithinBudget {

        @Override
        public int equalSubstring(String s, String t, int maxCost) {
            int cost = 0;
            int len = 0;
            int maxLen = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                cost += Math.abs(s.charAt(i) - t.charAt(i));
                len++;
                while (cost > maxCost) {
                    cost -= Math.abs(s.charAt(i - len + 1) - t.charAt(i - len + 1));
                    len--;
                }
                maxLen = Math.max(maxLen, len);
            }
            return maxLen;
        }
    }
}
