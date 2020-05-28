package com.leammin.leetcode.undone.medium;

/**
 * 394. 字符串解码
 * 
 * <p>给定一个经过编码的字符串，返回它解码后的字符串。</p>
 * 
 * <p>编码规则为: <code>k[encoded_string]</code>，表示其中方括号内部的 <em>encoded_string</em> 正好重复 <em>k</em> 次。注意 <em>k</em> 保证为正整数。</p>
 * 
 * <p>你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。</p>
 * 
 * <p>此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 <em>k</em> ，例如不会出现像&nbsp;<code>3a</code>&nbsp;或&nbsp;<code>2[4]</code>&nbsp;的输入。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * s = &quot;3[a]2[bc]&quot;, 返回 &quot;aaabcbc&quot;.
 * s = &quot;3[a2[c]]&quot;, 返回 &quot;accaccacc&quot;.
 * s = &quot;2[abc]3[cd]ef&quot;, 返回 &quot;abcabccdcdcdef&quot;.
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-05-28
 */
public interface DecodeString {
    String decodeString(String s);

    class Solution implements DecodeString {

        @Override
        public String decodeString(String s) {
            StringBuilder builder = new StringBuilder();

            return null;
        }

        private String decodeStringBuilder(String s, int from, int to) {
            StringBuilder builder = new StringBuilder();

            return null;
        }
    }
}
