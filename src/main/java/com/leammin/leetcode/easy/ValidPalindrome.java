package com.leammin.leetcode.easy;

/**
 * 125. 验证回文串
 * 
 * <div><p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。</p>
 *
 * <p><strong>说明：</strong>本题中，我们将空字符串定义为有效的回文串。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> "A man, a plan, a canal: Panama"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> "race a car"
 * <strong>输出:</strong> false
 * </pre>
 * </div>
 * 
 * @author Leammin
 * @date 2018-09-16
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (tail - head >= 1) {
            char h = toLower(chars[head]);
            char t = toLower(chars[tail]);
            if (isLower(h) || isNumber(h)) {
                if (isLower(t) || isNumber(t)) {
                    if (h == t) {
                        head++;
                        tail--;
                    } else {
                        return false;
                    }
                } else {
                    tail--;
                }
            }else {
                head++;   
            }
        }
        return true;
    }

    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        return c;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("a,bc,cba"));
    }
}
