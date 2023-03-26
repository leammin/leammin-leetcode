package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/">1638. 统计只差一个字符的子串数目</a>
 *
 * <p>给你两个字符串 <code>s</code> 和 <code>t</code> ，请你找出 <code>s</code> 中的非空子串的数目，这些子串满足替换 <strong>一个不同字符</strong> 以后，是 <code>t</code> 串的子串。换言之，请你找到 <code>s</code> 和 <code>t</code> 串中 <strong>恰好</strong> 只有一个字符不同的子字符串对的数目。</p>
 *
 * <p>比方说， <code>"<strong>compute</strong>r"</code> 和 <code>"<strong>computa</strong>tion"</code> 加粗部分只有一个字符不同： <code>'e'</code>/<code>'a'</code> ，所以这一对子字符串会给答案加 1 。</p>
 *
 * <p>请你返回满足上述条件的不同子字符串对数目。</p>
 *
 * <p>一个 <strong>子字符串</strong> 是一个字符串中连续的字符。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <b>输入：</b>s = "aba", t = "baba"
 * <b>输出：</b>6
 * <strong>解释：</strong>以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("<strong>a</strong>ba", "<strong>b</strong>aba")
 * ("<strong>a</strong>ba", "ba<strong>b</strong>a")
 * ("ab<strong>a</strong>", "<strong>b</strong>aba")
 * ("ab<strong>a</strong>", "ba<strong>b</strong>a")
 * ("a<strong>b</strong>a", "b<strong>a</strong>ba")
 * ("a<strong>b</strong>a", "bab<strong>a</strong>")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * </pre>
 * <strong>示例 2：</strong>
 *
 * <pre>
 * <b>输入：</b>s = "ab", t = "bb"
 * <b>输出：</b>3
 * <strong>解释：</strong>以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("<strong>a</strong>b", "<strong>b</strong>b")
 * ("<strong>a</strong>b", "b<strong>b</strong>")
 * ("<strong>ab</strong>", "<strong>bb</strong>")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * </pre>
 * <strong>示例 3：</strong>
 *
 * <pre>
 * <b>输入：</b>s = "a", t = "a"
 * <b>输出：</b>0
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <b>输入：</b>s = "abe", t = "bbc"
 * <b>输出：</b>10
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= s.length, t.length <= 100</code></li>
 * 	<li><code>s</code> 和 <code>t</code> 都只包含小写英文字母。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-27
 */
public interface CountSubstringsThatDifferByOneCharacter {
    int countSubstrings(String s, String t);

    static Testsuite<CountSubstringsThatDifferByOneCharacter> testsuite() {
        return Testsuite.<CountSubstringsThatDifferByOneCharacter>builder()
                .addExpected(t -> t.countSubstrings("aba", "baba"), 6)
                .addExpected(t -> t.countSubstrings("ab", "bb"), 3)
                .addExpected(t -> t.countSubstrings("a", "a"), 0)
                .addExpected(t -> t.countSubstrings("abe", "bbc"), 10)
                .build();
    }

    class Solution implements CountSubstringsThatDifferByOneCharacter {

        @Override
        public int countSubstrings(String s, String t) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            int sl = s.length();
            int tl = t.length();
            int[][] left = new int[sl + 2][tl + 2];
            for (int i = 1; i <= sl; i++) {
                for (int j = 1; j <= tl; j++) {
                    if (sc[i - 1] == tc[j - 1]) {
                        left[i][j] = 1 + left[i - 1][j - 1];
                    }
                }
            }
            int[][] right = new int[sl + 2][tl + 2];
            for (int i = sl; i >= 1; i--) {
                for (int j = tl; j >= 1; j--) {
                    if (sc[i - 1] == tc[j - 1]) {
                        right[i][j] = 1 + right[i + 1][j + 1];
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= sl; i++) {
                for (int j = 1; j <= tl; j++) {
                    if (sc[i - 1] != tc[j - 1]) {
                        res += (left[i - 1][j - 1] + 1) * (right[i + 1][j + 1] + 1);
                    }
                }
            }
            return res;
        }
    }
}
