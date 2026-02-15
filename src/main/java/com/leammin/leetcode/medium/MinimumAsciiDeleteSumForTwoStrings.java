package com.leammin.leetcode.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 712. 两个字符串的最小ASCII删除和
 *
 * <div><p>给定两个字符串<code>s1, s2</code>，找到使两个字符串相等所需删除字符的ASCII值的最小和。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> s1 = "sea", s2 = "eat"
 * <strong>输出:</strong> 231
 * <strong>解释:</strong> 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> s1 = "delete", s2 = "leet"
 * <strong>输出:</strong> 403
 * <strong>解释:</strong> 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt; s1.length, s2.length &lt;= 1000</code>。</li>
 * <li>所有字符串中的字符ASCII值在<code>[97, 122]</code>之间。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2019-04-02
 */
public interface MinimumAsciiDeleteSumForTwoStrings {
    int minimumDeleteSum(String s1, String s2);

    static Testsuite<MinimumAsciiDeleteSumForTwoStrings> testsuite() {
        return Testsuite.<MinimumAsciiDeleteSumForTwoStrings>builder()
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("sea", "eat"), 231))
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("delete", "leet"), 403))
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("sjfqkfxqoditw", "fxymelgo"), 1638))
                .build();
    }


    class Best implements MinimumAsciiDeleteSumForTwoStrings {

        @Override
        public int minimumDeleteSum(String s1, String s2) {
            // row 取 s1 的前 i 个字符 s1[0:i) i:0~n
            // col 取 s2 的前 j 个字符 s2[0:j) j:0~m
            // value 为 s1[0:i) s2[0:j) 时的解
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            }
            for (int j = 1; j <= m; j++) {
                dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    char c1 = s1.charAt(i - 1);
                    char c2 = s2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c2);
                    }
                }
            }
            return dp[n][m];
        }
    }

    class Solution2 implements MinimumAsciiDeleteSumForTwoStrings {
        private Map<Set<String>, Integer> cacheMap = new HashMap<>();

        @Override
        public int minimumDeleteSum(String s1, String s2) {
            if (s1.equals(s2)) {
                return 0;
            }
            Set<String> key = new HashSet<>();
            key.add(s1);
            key.add(s2);
            Integer cache = cacheMap.get(key);
            if (cache != null) {
                return cache;
            }
            int min = Integer.MAX_VALUE;
            String a = s1.length() > s2.length() ? s1 : s2;
            String b = s1.length() <= s2.length() ? s1 : s2;
            for (int i = 0; i < a.length(); i++) {
                min = Math.min(min, minimumDeleteSum(a.substring(0, i) + a.substring(i + 1), b) + a.charAt(i));
            }
            cacheMap.put(key, min);
            return min;
        }
    }

    class Solution1 implements MinimumAsciiDeleteSumForTwoStrings {
        private Map<Set<String>, Integer> cacheMap = new HashMap<>();

        @Override
        public int minimumDeleteSum(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            int[] count1 = charCount(chars1);

            char[] chars2 = s2.toCharArray();
            int[] count2 = charCount(chars2);

            int res = deleteSum(chars1, count2);
            res += deleteSum(chars2, count1);

            chars1 = delete(chars1, count2);
            chars2 = delete(chars2, count1);

            return res + minimumDeleteSum(chars1, chars2);
        }

        private int minimumDeleteSum(char[] chars1, char[] chars2) {
            if (Arrays.equals(chars1, chars2)) {
                return 0;
            }
            Set<String> key = new HashSet<>();
            key.add(String.valueOf(chars1));
            key.add(String.valueOf(chars2));
            Integer cache = cacheMap.get(key);
            if (cache != null) {
                return cache;
            }
            char[] c1;
            char[] c2;
            if (chars1.length > chars2.length) {
                c1 = chars1;
                c2 = chars2;
            } else {
                c1 = chars2;
                c2 = chars1;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < c1.length; i++) {
                min = Math.min(minimumDeleteSum(remove(c1, i), c2) + c1[i], min);
            }
            cacheMap.put(key, min);
            return min;
        }

        private int deleteSum(char[] chars, int[] count) {
            int res = 0;
            for (int i = 0; i < chars.length; i++) {
                if (count[chars[i] - 97] == 0) {
                    res += chars[i];
                }
            }
            return res;
        }

        private char[] delete(char[] chars, int[] count) {
            List<Integer> remove = new ArrayList<>(chars.length);
            for (int i = 0; i < chars.length; i++) {
                if (count[chars[i] - 97] == 0) {
                    remove.add(i);
                }
            }
            return remove(chars, remove.stream().mapToInt(Integer::valueOf).toArray());
        }

        private int[] charCount(char[] chars) {
            int[] res = new int[26];
            for (char c : chars) {
                res[c - 97]++;
            }
            return res;
        }

        private char[] remove(char[] chars, int... indexes) {
            if (indexes == null || indexes.length == 0) {
                return Arrays.copyOf(chars, chars.length);
            }
            int charsStart = 0;

            char[] res = new char[chars.length - indexes.length];
            int resStart = 0;

            for (int index : indexes) {
                if (index != charsStart) {
                    System.arraycopy(chars, charsStart, res, resStart, index - charsStart);
                }
                resStart += index - charsStart;
                charsStart = index + 1;
            }
            if (chars.length != charsStart) {
                System.arraycopy(chars, charsStart, res, resStart, chars.length - charsStart);
            }

            return res;
        }
    }
}

class MinimumAsciiDeleteSumForTwoStringsTest extends AbstractTest<MinimumAsciiDeleteSumForTwoStrings> {
}
