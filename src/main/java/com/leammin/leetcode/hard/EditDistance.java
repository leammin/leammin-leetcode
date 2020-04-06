package com.leammin.leetcode.hard;

/**
 * 72. 编辑距离
 *
 * <p>给定两个单词&nbsp;<em>word1</em> 和&nbsp;<em>word2</em>，计算出将&nbsp;<em>word1</em>&nbsp;转换成&nbsp;<em>word2 </em>所使用的最少操作数&nbsp;。</p>
 *
 * <p>你可以对一个单词进行如下三种操作：</p>
 *
 * <ol>
 * 	<li>插入一个字符</li>
 * 	<li>删除一个字符</li>
 * 	<li>替换一个字符</li>
 * </ol>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
 * <strong>输出:</strong> 3
 * <strong>解释:</strong>
 * horse -&gt; rorse (将 &#39;h&#39; 替换为 &#39;r&#39;)
 * rorse -&gt; rose (删除 &#39;r&#39;)
 * rose -&gt; ros (删除 &#39;e&#39;)
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
 * <strong>输出:</strong> 5
 * <strong>解释:</strong>
 * intention -&gt; inention (删除 &#39;t&#39;)
 * inention -&gt; enention (将 &#39;i&#39; 替换为 &#39;e&#39;)
 * enention -&gt; exention (将 &#39;n&#39; 替换为 &#39;x&#39;)
 * exention -&gt; exection (将 &#39;n&#39; 替换为 &#39;c&#39;)
 * exection -&gt; execution (插入 &#39;u&#39;)
 * </pre>
 *
 * @author Leammin
 * @date 2020-04-06
 */
public interface EditDistance {
    int minDistance(String word1, String word2);

    class Solution implements EditDistance {

        @Override
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            return minDistance(dp, word1, 0, word2, 0);
        }

        private int minDistance(int[][] dp, String word1, int i1, String word2, int i2) {
            if (dp[i1][i2] != 0) {
                return dp[i1][i2];
            }
            if (isSub(word1, i1, word2, i2)) {
                return dp[i1][i2] = Math.abs(word1.length() - i1 - word2.length() + i2);
            }
            if (word1.charAt(i1) == word2.charAt(i2)) {
                return dp[i1][i2] = minDistance(dp, word1, i1 + 1, word2, i2 + 1);
            }
            int delete = minDistance(dp, word1, i1 + 1, word2, i2);
            int insert = minDistance(dp, word1, i1, word2, i2 + 1);
            int replace = minDistance(dp, word1, i1 + 1, word2, i2 + 1);
            return dp[i1][i2] = Math.min(Math.min(insert, delete), replace) + 1;
        }

        private boolean isSub(String word1, int i1, String word2, int i2) {
            String longStr;
            String shortStr;
            int li, si;
            if (word1.length() - i1 > word2.length() - i2) {
                longStr = word1;
                li = i1;
                shortStr = word2;
                si = i2;
            } else {
                longStr = word2;
                li = i2;
                shortStr = word1;
                si = i1;
            }
            while (li < longStr.length() && si < shortStr.length()) {
                if (longStr.charAt(li++) == shortStr.charAt(si)) {
                    si++;
                }
            }
            return si == shortStr.length();
        }
    }

    class Solution2 implements EditDistance {

        @Override
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1]
                            : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
