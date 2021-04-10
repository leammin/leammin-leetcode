package com.leammin.leetcode.medium;

/**
 * 677. 键值映射
 * 
 * <p>实现一个 MapSum 类里的两个方法，<code>insert</code>&nbsp;和&nbsp;<code>sum</code>。</p>
 * 
 * <p>对于方法&nbsp;<code>insert</code>，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。</p>
 * 
 * <p>对于方法 <code>sum</code>，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>输入: insert(&quot;apple&quot;, 3), 输出: Null
 * 输入: sum(&quot;ap&quot;), 输出: 3
 * 输入: insert(&quot;app&quot;, 2), 输出: Null
 * 输入: sum(&quot;ap&quot;), 输出: 5
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-09
 */
public interface MapSumPairs {

    void insert(String key, int val);

    int sum(String prefix);

    class Solution implements MapSumPairs {
        Object[] trie = new Object[27];

        @Override
        public void insert(String key, int val) {
            Object[] node = trie;
            for (int i = 0; i < key.length(); i++) {
                int x = key.charAt(i) - 'a';
                if (node[x] == null) {
                    Object[] newNode = new Object[27];
                    newNode[26] = 0;
                    node[x] = newNode;
                }
                node = (Object[]) node[x];
            }
            node[26] = val;
        }

        @Override
        public int sum(String prefix) {
            Object[] node = trie;
            for (int i = 0; i < prefix.length(); i++) {
                int x = prefix.charAt(i) - 'a';
                if (node[x] == null) {
                    return 0;
                }
                node = (Object[]) node[x];
            }
            return sum(node);
        }

        public int sum(Object[] node) {
            int sum = (Integer) node[26];
            for (int i = 0; i < 26; i++) {
                if (node[i] != null) {
                    sum += sum((Object[]) node[i]);
                }
            }
            return sum;
        }
    }

    class Solution2 implements MapSumPairs {
        static class TrieNode {
            int val;
            int sum;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode trie = new TrieNode();

        @Override
        public void insert(String key, int val) {
            TrieNode node = this.trie;
            for (int i = 0; i < key.length(); i++) {
                int x = key.charAt(i) - 'a';
                if (node.next[x] == null) {
                    node.next[x] = new TrieNode();
                }
                node = node.next[x];
                node.sum += val;
            }
            if (node.val != 0) {
                int oldVal = node.val;
                node = this.trie;
                for (int i = 0; i < key.length(); i++) {
                    int x = key.charAt(i) - 'a';
                    node = node.next[x];
                    node.sum -= oldVal;
                }
            }
            node.val = val;

        }

        @Override
        public int sum(String prefix) {
            TrieNode node = this.trie;
            for (int i = 0; i < prefix.length(); i++) {
                int x = prefix.charAt(i) - 'a';
                if (node.next[x] == null) {
                    return 0;
                }
                node = node.next[x];
            }
            return node.sum;
        }
    }
}
