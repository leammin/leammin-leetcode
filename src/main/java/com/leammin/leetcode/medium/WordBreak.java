package com.leammin.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 139. 单词拆分
 *
 * <p>给定一个<strong>非空</strong>字符串 <em>s</em> 和一个包含<strong>非空</strong>单词列表的字典 <em>wordDict</em>，判定&nbsp;<em>s</em> 是否可以被空格拆分为一个或多个在字典中出现的单词。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * 	<li>拆分时可以重复使用字典中的单词。</li>
 * 	<li>你可以假设字典中没有重复的单词。</li>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;, &quot;code&quot;]
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 返回 true 因为 &quot;leetcode&quot; 可以被拆分成 &quot;leet code&quot;。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;, &quot;pen&quot;]
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 返回 true 因为 <code>&quot;</code>applepenapple<code>&quot;</code> 可以被拆分成 <code>&quot;</code>apple pen apple<code>&quot;</code>。
 * &nbsp;    注意你可以重复使用字典中的单词。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;, &quot;dog&quot;, &quot;sand&quot;, &quot;and&quot;, &quot;cat&quot;]
 * <strong>输出:</strong> false
 * </pre>
 *
 * @author Leammin
 * @date 2020-06-25
 */
public interface WordBreak {
    boolean wordBreak(String s, List<String> wordDict);

    static Testsuite<WordBreak> testsuite() {
        return Testsuite.<WordBreak>builder()
                .add(ExpectedTestcase.of(t -> t.wordBreak("leetcode", List.of("leet", "code")), true))
                .add(ExpectedTestcase.of(t -> t.wordBreak("applepenapple", List.of("apple", "pen")), true))
                .add(ExpectedTestcase.of(t -> t.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")), false))
                .add(ExpectedTestcase.of(t -> t.wordBreak("bb", List.of("a","b","bbb","bbbb")), true))
                .build();
    }


    class Solution implements WordBreak {

        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            Object[] words = new Object[53];
            for (String w : wordDict) {
                Object[] ws = words;
                for (int i = 0; i < w.length(); i++) {
                    int c = getIndex(w.charAt(i));
                    if (ws[c] == null) {
                        ws[c] = new Object[53];
                    }
                    ws = (Object[]) ws[c];
                }
                ws[52] = s;
            }

            boolean[] dp = new boolean[s.length()];
            for (int to = 1; to <= s.length(); to++) {
                for (int from = to - 1; from >= 0; from--) {
                    if ((from == 0 || dp[from - 1]) && inWords(words, s, from, to)) {
                        dp[to - 1] = true;
                        break;
                    }
                }
            }
            return dp[dp.length - 1];
        }

        private int getIndex(char c) {
            if (c >= 'a') {
                return c - 'a';
            } else {
                return c - 'A' + 26;
            }
        }

        private boolean inWords(Object[] words, String s, int from, int to) {
            Object[] ws = words;
            for (int i = from; i < to; i++) {
                int c = getIndex(s.charAt(i));
                ws = (Object[]) ws[c];
                if (ws == null) {
                    return false;
                }
            }
            return ws[52] == s;
        }
    }

    class Solution2 implements WordBreak {

        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> words = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()];
            for (int to = 1; to <= s.length(); to++) {
                for (int from = to - 1; from >= 0; from--) {
                    if ((from == 0 || dp[from - 1]) && inWords(words, s, from, to)) {
                        dp[to - 1] = true;
                        break;
                    }
                }
            }
            return dp[dp.length - 1];
        }

        private boolean inWords(Set<String> words, String s, int from, int to) {
            return words.contains(s.substring(from, to));
        }
    }
}

class WordBreakTest extends AbstractTest<WordBreak> {
}
