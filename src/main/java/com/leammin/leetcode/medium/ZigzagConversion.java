package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 6. Z 字形变换
 *
 * <p>将一个给定字符串根据给定的行数，以从上往下、从左到右进行&nbsp;Z 字形排列。</p>
 *
 * <p>比如输入字符串为 <code>&quot;LEETCODEISHIRING&quot;</code>&nbsp;行数为 3 时，排列如下：</p>
 *
 * <pre>L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * </pre>
 *
 * <p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>&quot;LCIRETOESIIGEDHN&quot;</code>。</p>
 *
 * <p>请你实现这个将字符串进行指定行数变换的函数：</p>
 *
 * <pre>string convert(string s, int numRows);</pre>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows = 3
 * <strong>输出:</strong> &quot;LCIRETOESIIGEDHN&quot;
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows =&nbsp;4
 * <strong>输出:</strong>&nbsp;&quot;LDREOEIIECIHNTSG&quot;
 * <strong>解释:</strong>
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G</pre>
 *
 * @author Leammin
 * @date 2022-09-23
 */
public interface ZigzagConversion {
    String convert(String s, int numRows);

    static Testsuite<ZigzagConversion> testsuite() {
        return Testsuite.<ZigzagConversion>builder()
                .addExpected(t -> t.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
                .addExpected(t -> t.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")
                .addExpected(t -> t.convert("ABC", 1), "ABC")
                .addExpected(t -> t.convert("ABC", 2), "ACB")
                .build();
    }


    class Solution implements ZigzagConversion {

        @Override
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j + i < s.length(); j += (numRows * 2 - 2)) {
                    sb.append(s.charAt(j + i));
                    if (i > 0 && i < numRows - 1 && j + (numRows * 2 - 2) - i < s.length()) {
                        sb.append(s.charAt(j + (numRows * 2 - 2) - i));
                    }
                }
            }
            return sb.toString();
        }
    }
}

class ZigzagConversionTest extends AbstractTest<ZigzagConversion> {
}
