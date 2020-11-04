package com.leammin.leetcode.undone.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * 
 * <p>给定一个<strong>非空</strong>字符串 <em>s</em> 和一个包含<strong>非空</strong>单词列表的字典 <em>wordDict</em>，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。</p>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>分隔时可以重复使用字典中的单词。</li>
 * 	<li>你可以假设字典中没有重复的单词。</li>
 * </ul>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入:
 * </strong>s = &quot;<code>catsanddog</code>&quot;
 * wordDict = <code>[&quot;cat&quot;, &quot;cats&quot;, &quot;and&quot;, &quot;sand&quot;, &quot;dog&quot;]</code>
 * <strong>输出:
 * </strong><code>[
 * &nbsp; &quot;cats and dog&quot;,
 * &nbsp; &quot;cat sand dog&quot;
 * ]</code>
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入:
 * </strong>s = &quot;pineapplepenapple&quot;
 * wordDict = [&quot;apple&quot;, &quot;pen&quot;, &quot;applepen&quot;, &quot;pine&quot;, &quot;pineapple&quot;]
 * <strong>输出:
 * </strong>[
 * &nbsp; &quot;pine apple pen apple&quot;,
 * &nbsp; &quot;pineapple pen apple&quot;,
 * &nbsp; &quot;pine applepen apple&quot;
 * ]
 * <strong>解释:</strong> 注意你可以重复使用字典中的单词。
 * </pre>
 * 
 * <p><strong>示例&nbsp;3：</strong></p>
 * 
 * <pre><strong>输入:
 * </strong>s = &quot;catsandog&quot;
 * wordDict = [&quot;cats&quot;, &quot;dog&quot;, &quot;sand&quot;, &quot;and&quot;, &quot;cat&quot;]
 * <strong>输出:
 * </strong>[]
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-11-01
 */
public interface WordBreakIi {
    List<String> wordBreak(String s, List<String> wordDict);

    class Solution implements WordBreakIi {

        @Override
        public List<String> wordBreak(String s, List<String> wordDict) {
            Object[] dicTree = buildTree(wordDict);
            return wordBreak(s, 0, dicTree, new ArrayList[s.length()]);
        }

        private List<String> wordBreak(String s, int start, Object[] dicTree, ArrayList<String>[] cache) {
            if (cache[start] != null) {
                return cache[start];
            }
            Object[] tree = dicTree;
            ArrayList<String> result = new ArrayList<>();
            for (int i = start; i < s.length(); i++) {
                int index = getIndex(s, i);
                tree = (Object[]) tree[index];
                if (tree == null) {
                    break;
                }
                if (tree[52] != null) {
                    if (i == s.length() - 1) {
                        result.add(s.substring(start));
                    } else {
                        List<String> sub = wordBreak(s, i + 1, dicTree, cache);
                        if (!sub.isEmpty()) {
                            String pre = s.substring(start, i + 1);
                            result.ensureCapacity(result.size() + sub.size());
                            for (String e : sub) {
                                result.add(pre + " " + e);
                            }
                        }
                    }
                }
            }
            return cache[start] = result;
        }

        private Object[] buildTree(List<String> wordDict) {
            Object[] dicTree = new Object[53];
            Object flag = new Object();
            for (String word : wordDict) {
                Object[] tree = dicTree;
                for (int i = 0; i < word.length(); i++) {
                    int index = getIndex(word, i);
                    if (tree[index] == null) {
                        tree[index] = new Object[53];
                    }
                    tree = (Object[]) tree[index];
                }
                tree[52] = flag;
            }
            return dicTree;
        }

        private int getIndex(String word, int i) {
            char c = word.charAt(i);
            return c >= 'a' ? c - 'a' + 26 : c - 'A';
        }
    }
}
