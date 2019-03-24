package com.leammin.leetcode.medium;

/**
 * 8. 字符串转整数 (atoi)
 *
 * <div><p>实现 <code>atoi</code>，将字符串转为整数。</p>
 *
 * <p>该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。</p>
 *
 * <p>字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。</p>
 *
 * <p>当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。</p>
 *
 * <p>若函数不能执行有效的转换，返回 0。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>假设我们的环境只能存储 32 位有符号整数，其数值范围是&nbsp;[−2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>− 1]。如果数值超过可表示的范围，则返回 &nbsp;INT_MAX (2<sup>31&nbsp;</sup>− 1) 或&nbsp;INT_MIN (−2<sup>31</sup>) 。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> "42"
 * <strong>输出:</strong> 42
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> "   -42"
 * <strong>输出:</strong> -42
 * <strong>解释: </strong>第一个非空白字符为 '-', 它是一个负号。
 * &nbsp;    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入:</strong> "4193 with words"
 * <strong>输出:</strong> 4193
 * <strong>解释:</strong> 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * </pre>
 *
 * <p><strong>示例&nbsp;4:</strong></p>
 *
 * <pre><strong>输入:</strong> "words and 987"
 * <strong>输出:</strong> 0
 * <strong>解释:</strong> 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。</pre>
 *
 * <p><strong>示例&nbsp;5:</strong></p>
 *
 * <pre><strong>输入:</strong> "-91283472332"
 * <strong>输出:</strong> -2147483648
 * <strong>解释:</strong> 数字 "-91283472332" 超过 32 位有符号整数范围。
 * &nbsp;    因此返回 INT_MIN (−2<sup>31</sup>) 。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-09
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean isPositive;
        int index = 0;
        while (true) {
            if (index >= chars.length) {
                return 0;
            } else if (chars[index] == '-') {
                isPositive = false;
                index++;
                break;
            } else if (chars[index] == '+') {
                isPositive = true;
                index++;
                break;
            } else if (chars[index] <= '9' && chars[index] >= '0') {
                isPositive = true;
                break;
            } else if (Character.isWhitespace(chars[index])) {
                index++;
            } else {
                return 0;
            }
        }
        long res = 0;
        for (; index < chars.length; index++) {
            if (chars[index] <= '9' && chars[index] >= '0') {
                res = res * 10 + chars[index] - '0';
                if (res > Integer.MAX_VALUE) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        
        return (int) (isPositive ? res : -res);
    }

    public static void main(String[] args) {
        System.out.println(StringToInteger.myAtoi(String.valueOf((long)Integer.MAX_VALUE+1)));
    }
}

