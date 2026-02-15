package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 
 * <p>设计一个支持以下两种操作的数据结构：</p>
 * 
 * <pre>void addWord(word)
 * bool search(word)
 * </pre>
 * 
 * <p>search(word)&nbsp;可以搜索文字或正则表达式字符串，字符串只包含字母&nbsp;<code>.</code>&nbsp;或&nbsp;<code>a-z</code>&nbsp;。&nbsp;<code>.</code> 可以表示任何一个字母。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>addWord(&quot;bad&quot;)
 * addWord(&quot;dad&quot;)
 * addWord(&quot;mad&quot;)
 * search(&quot;pad&quot;) -&gt; false
 * search(&quot;bad&quot;) -&gt; true
 * search(&quot;.ad&quot;) -&gt; true
 * search(&quot;b..&quot;) -&gt; true
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <p>你可以假设所有单词都是由小写字母 <code>a-z</code>&nbsp;组成的。</p>
 * 
 * 
 * @author Leammin
 * @date 2021-04-09
 */
public interface AddAndSearchWordDataStructureDesign {

    /** Initialize your data structure here. */
//    public WordDictionary() {
//
//    }

    /**
     * Adds a word into the data structure.
     */
    void addWord(String word);

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    boolean search(String word);

    static Testsuite<AddAndSearchWordDataStructureDesign> testsuite() {
        return Testsuite.<AddAndSearchWordDataStructureDesign>builder()
                .addExpected(t -> {
                    t.addWord("bad");
                    t.addWord("dad");
                    t.addWord("mad");
                    return new boolean[]{
                            t.search("pad"),
                            t.search("bad"),
                            t.search(".ad"),
                            t.search("b..")
                    };
                }, new boolean[]{
                        false,
                        true,
                        true,
                        true
                })
                .addExpected(t -> {
//                    ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
//                    [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
                    t.addWord("a");
                    t.addWord("a");
                    return new boolean[]{
                            t.search("."),
                            t.search("a"),
                            t.search("aa"),
                            t.search("a"),
                            t.search(".a"),
                            t.search("a."),
                    };
                }, new boolean[]{
                        true,
                        true,
                        false,
                        true,
                        false,
                        false,
                })
                .build();
    }


    class Solution implements AddAndSearchWordDataStructureDesign {
        static class TrieNode {
            boolean end;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode trie = new TrieNode();

        @Override
        public void addWord(String word) {
            TrieNode node = trie;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (node.next[x] == null) {
                    node.next[x] = new TrieNode();
                }
                node = node.next[x];
            }
            node.end = true;
        }

        @Override
        public boolean search(String word) {
            return search(word, 0, trie);
        }

        private boolean search(String word, int from, TrieNode node) {
            for (int i = from; i < word.length() && node != null; i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (int j = 0; j < node.next.length; j++) {
                        if (node.next[j] != null && search(word, i + 1, node.next[j])) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    node = node.next[c - 'a'];
                }
            }
            return node != null && node.end;
        }
    }
}

class AddAndSearchWordDataStructureDesignTest extends AbstractTest<AddAndSearchWordDataStructureDesign> {
}
