package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ']') {
                    List<Character> list = new ArrayList<>();
                    Character cc;
                    while (!Character.valueOf('[').equals(cc = stack.pop())) {
                        list.add(cc);
                    }
                    int times = 0;
                    int d = 1;
                    while ((cc = stack.peek()) != null && cc <= '9' && cc >= '0') {
                        times += (cc - '0') * d;
                        d *= 10;
                        stack.pop();
                    }
                    for (int j = 0; j < times; j++) {
                        for (int k = list.size() - 1; k >= 0; k--) {
                            stack.push(list.get(k));
                        }
                    }
                } else {
                    stack.push(c);
                }
            }
            StringBuilder res = new StringBuilder(stack.size());
            while (!stack.isEmpty()) {
                res.append(stack.pollLast().charValue());
            }
            return res.toString();
        }
    }
}
