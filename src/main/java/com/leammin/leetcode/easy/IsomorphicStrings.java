package com.leammin.leetcode.easy;

/**
 * 205. 同构字符串
 *
 * <p>给定两个字符串&nbsp;<em><strong>s&nbsp;</strong></em>和&nbsp;<strong><em>t</em></strong>，判断它们是否是同构的。</p>
 *
 * <p>如果&nbsp;<em><strong>s&nbsp;</strong></em>中的字符可以被替换得到&nbsp;<strong><em>t&nbsp;</em></strong>，那么这两个字符串是同构的。</p>
 *
 * <p>所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;egg&quot;, </code><strong><em>t = </em></strong><code>&quot;add&quot;</code>
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;foo&quot;, </code><strong><em>t = </em></strong><code>&quot;bar&quot;</code>
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;paper&quot;, </code><strong><em>t = </em></strong><code>&quot;title&quot;</code>
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>说明:</strong><br>
 * 你可以假设&nbsp;<em><strong>s&nbsp;</strong></em>和 <strong><em>t </em></strong>具有相同的长度。</p>
 *
 * @author Leammin
 * @date 2020-06-27
 */
public interface IsomorphicStrings {
    boolean isIsomorphic(String s, String t);

    class Solution implements IsomorphicStrings {

        @Override
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            char[] smap = new char[96];
            char[] tmap = new char[96];
            for (int i = 0; i < n; i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                int sci = sc - 32;
                int tci = tc - 32;
                if ((smap[sci] > 0 && smap[sci] != tc) || (tmap[tci] > 0 && tmap[tci] != sc)) {
                    return false;
                } else {
                    smap[sci] = tc;
                    tmap[tci] = sc;
                }
            }
            return true;
        }
    }
}
