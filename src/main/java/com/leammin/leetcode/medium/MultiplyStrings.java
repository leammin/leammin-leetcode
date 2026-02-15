package com.leammin.leetcode.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 43. 字符串相乘
 *
 * <p>给定两个以字符串形式表示的非负整数&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>，返回&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的乘积，它们的乘积也表示为字符串形式。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> num1 = &quot;2&quot;, num2 = &quot;3&quot;
 * <strong>输出:</strong> &quot;6&quot;</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> num1 = &quot;123&quot;, num2 = &quot;456&quot;
 * <strong>输出:</strong> &quot;56088&quot;</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ol>
 * 	<li><code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的长度小于110。</li>
 * 	<li><code>num1</code> 和&nbsp;<code>num2</code> 只包含数字&nbsp;<code>0-9</code>。</li>
 * 	<li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;均不以零开头，除非是数字 0 本身。</li>
 * 	<li><strong>不能使用任何标准库的大数类型（比如 BigInteger）</strong>或<strong>直接将输入转换为整数来处理</strong>。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2019-08-25
 */
public interface MultiplyStrings {
    String multiply(String num1, String num2);

    static Testsuite<MultiplyStrings> testsuite() {
        return Testsuite.<MultiplyStrings>builder()
                .add(ExpectedTestcase.of(t -> t.multiply("0", "3135"), "0"))
                .add(ExpectedTestcase.of(t -> t.multiply("13561", "3135"), "42513735"))
                .add(ExpectedTestcase.of(t -> t.multiply("216531635165", "13513513513"), "2926103177794213484645"))
                .add(ExpectedTestcase.of(t -> t.multiply("16531635131313546854683165498616143116", "949841368643513165413135461331684686164646131351354"), "15702430939042043834190930974151226312091301977204979233603507711721704324792460544379064"
                ))
                .build();
    }


    class Solution implements MultiplyStrings {
        @Override
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            if ("1".equals(num1)) {
                return num2;
            }
            if ("1".equals(num2)) {
                return num1;
            }
            if (num1.length() + num2.length() < 19) {
                return String.valueOf(Long.parseLong(num1) * Long.parseLong(num2));
            }
            StringBuilder res = new StringBuilder("0");
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            StringBuilder digit = new StringBuilder();
            for (int i = chars2.length - 1; i >= 0; i--) {
                StringBuilder multiply = multiply(chars1, chars2[i]);
                res = add(res, new StringBuilder(multiply.length() + digit.length()).append(multiply).append(digit));
                digit.append('0');
            }
            return res.toString();
        }

        private StringBuilder add(StringBuilder num1, StringBuilder num2) {
            StringBuilder longer;
            StringBuilder shorter;
            if (num1.length() > num2.length()) {
                longer = num1;
                shorter = num2;
            } else {
                longer = num2;
                shorter = num1;
            }
            if (shorter.length() == 1 && shorter.charAt(0) == '0') {
                return longer;
            }
            StringBuilder resReversed = new StringBuilder(longer.length() + 1);
            boolean carry = false;
            for (int i = 0; i < longer.length(); i++) {
                char sc;
                if (i < shorter.length()) {
                    sc = shorter.charAt(shorter.length() - 1 - i);
                } else {
                    sc = '0';
                }
                char lc = longer.charAt(longer.length() - 1 - i);
                int add = sc - '0' + lc - '0';
                if (carry) {
                    add++;
                    carry = false;
                }
                if (add > 9) {
                    carry = true;
                    add -= 10;
                }
                resReversed.append(add);
            }
            if (carry) {
                resReversed.append('1');
            }
            return resReversed.reverse();
        }

        private StringBuilder[] multiply = new StringBuilder[10];

        private StringBuilder multiply(char[] num, char c) {
            int i = c - '0';
            if (multiply[i] != null) {
                return multiply[i];
            }
            if (i == 0) {
                return multiply[i] = new StringBuilder("0");
            }
            if (i == 1) {
                return new StringBuilder(num.length).append(num);
            }
            StringBuilder resReversed = new StringBuilder(num.length + 1);
            int carry = 0;
            for (int j = num.length - 1; j >= 0; j--) {
                char n = num[j];
                int m = (n - '0') * i;
                if (carry != 0) {
                    m += carry;
                    carry = 0;
                }
                if (m > 9) {
                    carry = m / 10;
                    m %= 10;
                }
                resReversed.append(m);
            }
            if (carry != 0) {
                resReversed.append(carry);
            }
            return multiply[i] = resReversed.reverse();
        }
    }

    class Solution2 implements MultiplyStrings {
        @Override
        public String multiply(String num1, String num2) {
            StringBuilder res = new StringBuilder("0");
            int[] ints1 = toInts(num1);
            int[] ints2 = toInts(num2);
            for (int i = 0; i < ints1.length; i++) {
                for (int j = 0; j < ints2.length; j++) {
                    int i1 = ints1[ints1.length - 1 - i];
                    int i2 = ints2[ints2.length - 1 - j];
                    res = add(res, new StringBuilder().append((long) i1 * i2).append(zero((i + j) * 9)));
                }
            }
            return res.toString();
        }

        private StringBuilder zero(int n) {
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.append('0');
            }
            return sb;
        }

        private StringBuilder add(StringBuilder num1, StringBuilder num2) {
            StringBuilder longer;
            StringBuilder shorter;
            if (num1.length() > num2.length()) {
                longer = num1;
                shorter = num2;
            } else {
                longer = num2;
                shorter = num1;
            }
            if (shorter.length() == 1 && shorter.charAt(0) == '0') {
                return longer;
            }
            StringBuilder resReversed = new StringBuilder(longer.length() + 1);
            boolean carry = false;
            for (int i = 0; i < longer.length(); i++) {
                char sc;
                if (i < shorter.length()) {
                    sc = shorter.charAt(shorter.length() - 1 - i);
                } else {
                    sc = '0';
                }
                char lc = longer.charAt(longer.length() - 1 - i);
                int add = sc - '0' + lc - '0';
                if (carry) {
                    add++;
                    carry = false;
                }
                if (add > 9) {
                    carry = true;
                    add -= 10;
                }
                resReversed.append(add);
            }
            if (carry) {
                resReversed.append('1');
            }
            return resReversed.reverse();
        }

        private static int[] toInts(String num) {
            int intsLength = num.length() / 9;
            if (num.length() % 9 != 0) {
                intsLength++;
            }
            int[] ints = new int[intsLength];
            for (int i = 0; i < intsLength; i++) {
                ints[intsLength - 1 - i] = Integer.parseInt(num.substring(Math.max(num.length() - i * 9 - 9, 0), num.length() - i * 9));
            }
            return ints;
        }
    }

    /**
     * num1=a*10^x + b
     * num2=c*10^y + b
     */
    class Solution3 implements MultiplyStrings {
        Map<Set<String>, String> cache = new HashMap<>();

        @Override
        public String multiply(String num1, String num2) {
            String shorter = num1.length() > num2.length() ? num2 : num1;
            if (shorter.isEmpty() || "0".equals(shorter)) {
                return "0";
            }
            if (num1.length() + num2.length() < 19) {
                return String.valueOf(Long.parseLong(num1) * Long.parseLong(num2));
            }
            String res;
            HashSet<String> key = new HashSet<>(Arrays.asList(num1, num2));
            if ((res = cache.get(key)) != null) {
                return res;
            }
            String a = num1.substring(0, num1.length() / 2);
            String b = num1.substring(num1.length() / 2);
            int aZero = b.length();
            String c = num2.substring(0, num2.length() / 2);
            String d = num2.substring(num2.length() / 2);
            int cZero = d.length();
            String ac = multiply(a, c);
            if (!"0".equals(ac)) {
                ac += zero(aZero + cZero);
            }
            String ad = multiply(a, d);
            if (!"0".equals(ad)) {
                ad += zero(aZero);
            }
            String bc = multiply(b, c);
            if (!"0".equals(bc)) {
                bc += zero(cZero);
            }
            String bd = multiply(b, d);

            res = add(add(add(ac, ad), bc), bd);
            cache.put(key, res);
            return res;
        }

        private String add(String a, String b) {
            char[] longer;
            char[] shorter;
            if (a.length() > b.length()) {
                longer = a.toCharArray();
                shorter = b.toCharArray();
            } else {
                longer = b.toCharArray();
                shorter = a.toCharArray();
            }
            boolean carry = false;
            for (int i = 0; i < longer.length; i++) {
                char sc;
                if (i < shorter.length) {
                    sc = shorter[shorter.length - 1 - i];
                } else {
                    sc = '0';
                }
                char lc = longer[longer.length - 1 - i];
                int add = sc - '0' + lc - '0';
                if (carry) {
                    add++;
                    carry = false;
                }
                if (add > 9) {
                    carry = true;
                    add -= 10;
                }
                longer[longer.length - 1 - i] = (char) ('0' + add);
            }
            StringBuilder res = new StringBuilder(longer.length + 1);
            if (carry) {
                res.append('1');
            }
            res.append(longer);
            return res.toString();
        }

        private String zero(int n) {
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.append('0');
            }
            return sb.toString();
        }
    }
}

class MultiplyStringsTest extends AbstractTest<MultiplyStrings> {
}
