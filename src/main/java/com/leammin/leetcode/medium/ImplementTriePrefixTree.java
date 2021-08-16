package com.leammin.leetcode.medium;

/**
 * 208. 实现 Trie (前缀树)
 * 
 * <p>实现一个 Trie (前缀树)，包含&nbsp;<code>insert</code>,&nbsp;<code>search</code>, 和&nbsp;<code>startsWith</code>&nbsp;这三个操作。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>Trie trie = new Trie();
 * 
 * trie.insert(&quot;apple&quot;);
 * trie.search(&quot;apple&quot;);   // 返回 true
 * trie.search(&quot;app&quot;);     // 返回 false
 * trie.startsWith(&quot;app&quot;); // 返回 true
 * trie.insert(&quot;app&quot;);   
 * trie.search(&quot;app&quot;);     // 返回 true</pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>你可以假设所有的输入都是由小写字母&nbsp;<code>a-z</code>&nbsp;构成的。</li>
 * 	<li>保证所有输入均为非空字符串。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-04-09
 */
public interface ImplementTriePrefixTree {

    /** Initialize your data structure here. */
//    public Trie() {
//
//    }

    /**
     * Inserts a word into the trie.
     */
    void insert(String word);

    /**
     * Returns if the word is in the trie.
     */
    boolean search(String word);

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    boolean startsWith(String prefix);

    class Solution implements ImplementTriePrefixTree {
        Object flag = new Object();
        Object[] trie = new Object[27];


        @Override
        public void insert(String word) {
            Object[] node = trie;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (node[x] == null) {
                    node[x] = new Object[27];
                }
                node = (Object[]) node[x];
            }
            node[26] = flag;
        }

        @Override
        public boolean search(String word) {
            Object[] node = trie;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (node[x] == null) {
                    return false;
                }
                node = (Object[]) node[x];
            }
            return node[26] != null;
        }

        @Override
        public boolean startsWith(String prefix) {
            Object[] node = trie;
            for (int i = 0; i < prefix.length(); i++) {
                int x = prefix.charAt(i) - 'a';
                if (node[x] == null) {
                    return false;
                }
                node = (Object[]) node[x];
            }
            return true;
        }
    }
}
