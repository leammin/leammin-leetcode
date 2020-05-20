package com.leammin.leetcode.undone.medium;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 *
 * <p>给你一个字符串&nbsp;<code>s</code>&nbsp;，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即&nbsp;&#39;a&#39;，&#39;e&#39;，&#39;i&#39;，&#39;o&#39;，&#39;u&#39; ，在子字符串中都恰好出现了偶数次。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;eleetminicoworoep&quot;
 * <strong>输出：</strong>13
 * <strong>解释：</strong>最长子字符串是 &quot;leetminicowor&quot; ，它包含 <strong>e，i，o</strong>&nbsp;各 2 个，以及 0 个 <strong>a</strong>，<strong>u </strong>。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;leetcodeisgreat&quot;
 * <strong>输出：</strong>5
 * <strong>解释：</strong>最长子字符串是 &quot;leetc&quot; ，其中包含 2 个 <strong>e</strong> 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;bcbcbc&quot;
 * <strong>输出：</strong>6
 * <strong>解释：</strong>这个示例中，字符串 &quot;bcbcbc&quot; 本身就是最长的，因为所有的元音 <strong>a，</strong><strong>e，</strong><strong>i，</strong><strong>o，</strong><strong>u</strong> 都出现了 0 次。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 5 x 10^5</code></li>
 * 	<li><code>s</code>&nbsp;只包含小写英文字母。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-05-20
 */
public interface FindTheLongestSubstringContainingVowelsInEvenCounts {
    int findTheLongestSubstring(String s);

    class Solution implements FindTheLongestSubstringContainingVowelsInEvenCounts {

        @Override
        public int findTheLongestSubstring(String s) {
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};

            int[][] dp = new int[0b11111][];
            int d = 0;
            for (int i = 0; i < s.length(); i++) {
                int x = indexOf(vowels, s.charAt(i));
                d ^= x > 0 ? 1 << x : 0;
                if (dp[d] == null) {
                    dp[d] = new int[]{i, -1};
                } else {
                    dp[d][1] = i;
                }
            }
            int max = dp[0] == null ? 0 : (Math.max(dp[0][0], dp[0][1]) + 1);
            for (int i = 1; i < dp.length; i++) {
                if (dp[i] != null && dp[i][1] >= 0) {
                    max = Math.max(max, dp[i][1] - dp[i][0]);
                }
            }
            return max;
        }

        private int indexOf(char[] cs, char target) {
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
