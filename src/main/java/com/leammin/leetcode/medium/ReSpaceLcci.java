package com.leammin.leetcode.medium;

import java.util.*;

/**
 * 面试题 17.13. 恢复空格
 *
 * <p>哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子<code>&quot;I reset the computer. It still didn&rsquo;t boot!&quot;</code>已经变成了<code>&quot;iresetthecomputeritstilldidntboot&quot;</code>。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典<code>dictionary</code>，不过，有些词没在词典里。假设文章用<code>sentence</code>表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。</p>
 *
 * <p><strong>注意：</strong>本题相对原题稍作改动，只需返回未识别的字符数</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * dictionary = [&quot;looked&quot;,&quot;just&quot;,&quot;like&quot;,&quot;her&quot;,&quot;brother&quot;]
 * sentence = &quot;jesslookedjustliketimherbrother&quot;
 * <strong>输出：</strong> 7
 * <strong>解释：</strong> 断句后为&quot;<strong>jess</strong> looked just like <strong>tim</strong> her brother&quot;，共7个未识别字符。
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= len(sentence) &lt;= 1000</code></li>
 * 	<li><code>dictionary</code>中总字符数不超过 150000。</li>
 * 	<li>你可以认为<code>dictionary</code>和<code>sentence</code>中只包含小写字母。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-07-09
 */
public interface ReSpaceLcci {
    int respace(String[] dictionary, String sentence);

    class Solution implements ReSpaceLcci {

        @Override
        public int respace(String[] dictionary, String sentence) {
            int n = sentence.length();
            Set<String> dicSet = new HashSet<>(Arrays.asList(dictionary));
            int[] dp = new int[n + 1];
            for (int head = n - 1; head >= 0; head--) {
                int min = Integer.MAX_VALUE;
                for (int tail = head + 1; tail <= n; tail++) {
                    String sub = sentence.substring(head, tail);
                    if (dicSet.contains(sub)) {
                        min = Math.min(min, dp[tail]);
                    }
                }
                dp[head] = Math.min(min, dp[head + 1] + 1);
            }
            return dp[0];
        }
    }

    class Solution2 implements ReSpaceLcci {

        @Override
        public int respace(String[] dictionary, String sentence) {
            Object[] trie = trie(dictionary);
            int n = sentence.length();
            int[] dp = new int[n + 1];
            for (int head = n - 1; head >= 0; head--) {
                int min = Integer.MAX_VALUE;
                Object[] tree = trie;
                for (int tail = head + 1; tail <= n; tail++) {
                    tree = (Object[]) tree[sentence.charAt(tail - 1) - 'a'];
                    if (tree == null) {
                        break;
                    }
                    if (tree[26] != null) {
                        // end
                        min = Math.min(min, dp[tail]);
                    }
                    if (min == 0) {
                        break;
                    }
                }
                dp[head] = Math.min(min, dp[head + 1] + 1);
            }
            return dp[0];
        }

        public Object[] trie(String[] dictionary) {
            Object[] res = new Object[27];
            for (String word : dictionary) {
                Object[] tree = res;
                for (int i = 0; i < word.length(); i++) {
                    int ci = word.charAt(i) - 'a';
                    if (tree[ci] == null) {
                        tree[ci] = new Object[27];
                    }
                    tree = (Object[]) tree[ci];
                }
                tree[26] = Object.class;
            }
            return res;
        }

    }

    class Solution3 implements ReSpaceLcci {

        @Override
        public int respace(String[] dictionary, String sentence) {
            Map<Integer, String> hashDir = new HashMap<>();
            for (String s : dictionary) {
                hashDir.put(hash(s), s);
            }
            int n = sentence.length();
            int[] dp = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                int min = Integer.MAX_VALUE;
                int hash = 0;
                for (int j = i; j < n; j++) {
                    hash += (hash * 31 + sentence.charAt(j) - 'a' + 1) % 1000000007;
                    if (equals(hashDir.get(hash), sentence, i, j + 1)) {
                        min = Math.min(min, dp[j + 1]);
                    }
                }
                dp[i] = Math.min(min, dp[i + 1] + 1);
            }
            return dp[0];
        }

        private boolean equals(String s1, String s2, int from, int to) {
            if (s1 == null || s1.length() != to - from) {
                return false;
            }
            for (int i = 0; i < to - from; i++) {
                if (s1.charAt(i) != s2.charAt(from + i)) {
                    return false;
                }
            }
            return true;
        }

        private int hash(String str) {
            int hash = 0;
            for (int i = 0; i < str.length(); i++) {
                hash += (hash * 31 + str.charAt(i) - 'a' + 1) % 1000000007;
            }
            return hash;
        }
    }
}
