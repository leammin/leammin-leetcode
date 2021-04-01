package com.leammin.leetcode.easy;

/**
 * 345. 反转字符串中的元音字母
 *
 * <p>编写一个函数，以字符串作为输入，反转该字符串中的元音字母。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;hello&quot;
 * <strong>输出: </strong>&quot;holle&quot;
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;leetcode&quot;
 * <strong>输出: </strong>&quot;leotcede&quot;</pre>
 *
 * <p><strong>说明:</strong><br>
 * 元音字母不包含字母&quot;y&quot;。</p>
 *
 *
 * @author Leammin
 * @date 2021-03-31
 */
public interface ReverseVowelsOfAString {
    String reverseVowels(String s);

    class Solution implements ReverseVowelsOfAString {
        // 'a','e','i','o','u','A','E','I','O','U'

        @Override
        public String reverseVowels(String s) {
            char[] ca = s.toCharArray();
            int l = 0, r = ca.length - 1;
            while (l < r) {
                boolean lv = isVowel(ca[l]);
                boolean rv = isVowel(ca[r]);
                if (lv && rv) {
                    swap(ca, l, r);
                    l++;
                    r--;
                }
                if (!lv) {
                    l++;
                }
                if (!rv) {
                    r--;
                }
            }
            return new String(ca);
        }

        private void swap(char[] ca, int i, int j) {
            char t = ca[i];
            ca[i] = ca[j];
            ca[j] = t;
        }

        private boolean isVowel(char c) {
            if (c < 'a') {
                c += 'a' - 'A';
            }
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
