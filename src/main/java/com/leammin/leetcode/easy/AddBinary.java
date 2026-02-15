package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 67. 二进制求和
 *
 * <p>给定两个二进制字符串，返回他们的和（用二进制表示）。</p>
 *
 * <p>输入为<strong>非空</strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
 * <strong>输出:</strong> &quot;100&quot;</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
 * <strong>输出:</strong> &quot;10101&quot;</pre>
 *
 * @author Leammin
 * @date 2020-06-23
 */
public interface AddBinary {
    String addBinary(String a, String b);

    static Testsuite<AddBinary> testsuite() {
        return Testsuite.<AddBinary>builder()
                .add(ExpectedTestcase.of(t -> t.addBinary("11", "1"), "100"))
                .add(ExpectedTestcase.of(t -> t.addBinary("1010", "1011"), "10101"))
                .build();
    }
    
    class Solution implements AddBinary {

        @Override
        public String addBinary(String a, String b) {
            int maxLen = Math.max(a.length(), b.length());
            char[] res = new char[maxLen + 1];
            boolean carry = false;
            for (int i = 1; i <= maxLen; i++) {
                int ai = a.length() - i;
                int bi = b.length() - i;
                boolean a1 = ai >= 0 && a.charAt(ai) == '1';
                boolean b1 = bi >= 0 && b.charAt(bi) == '1';
                res[res.length - i] = (a1 ^ b1 ^ carry) ? '1' : '0';
                carry = (carry && a1) || (carry && b1) || (a1 && b1);
            }
            res[0] = carry ? '1' : '0';
            return new String(res, carry ? 0 : 1, carry ? res.length : res.length - 1);
        }
    }
}

class AddBinaryTest extends AbstractTest<AddBinary> {
    
}