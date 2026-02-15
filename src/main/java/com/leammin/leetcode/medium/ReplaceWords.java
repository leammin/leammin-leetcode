package com.leammin.leetcode.medium;

import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 648. 单词替换
 * 
 * <p>在英语中，我们有一个叫做&nbsp;<code>词根</code>(root)的概念，它可以跟着其他一些词组成另一个较长的单词&mdash;&mdash;我们称这个词为&nbsp;<code>继承词</code>(successor)。例如，词根<code>an</code>，跟随着单词&nbsp;<code>other</code>(其他)，可以形成新的单词&nbsp;<code>another</code>(另一个)。</p>
 * 
 * <p>现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有<code>继承词</code>用<code>词根</code>替换掉。如果<code>继承词</code>有许多可以形成它的<code>词根</code>，则用最短的词根替换它。</p>
 * 
 * <p>你需要输出替换之后的句子。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> dict(词典) = [&quot;cat&quot;, &quot;bat&quot;, &quot;rat&quot;]
 * sentence(句子) = &quot;the cattle was rattled by the battery&quot;
 * <strong>输出:</strong> &quot;the cat was rat by the bat&quot;
 * </pre>
 * 
 * <p><strong>注:</strong></p>
 * 
 * <ol>
 * 	<li>输入只包含小写字母。</li>
 * 	<li>1 &lt;= 字典单词数 &lt;=1000</li>
 * 	<li>1 &lt;=&nbsp; 句中词语数&nbsp;&lt;= 1000</li>
 * 	<li>1 &lt;= 词根长度 &lt;= 100</li>
 * 	<li>1 &lt;= 句中词语长度&nbsp;&lt;= 1000</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-04-09
 */
public interface ReplaceWords {
    String replaceWords(List<String> dict, String sentence);

    static Testsuite<ReplaceWords> testsuite() {
        return Testsuite.<ReplaceWords>builder()
                .addExpected(t -> t.replaceWords(List.of("cat", "bat", "rat"),
                        "the cattle was rattled by the battery"),
                        "the cat was rat by the bat")
                .build();
    }


    class Solution implements ReplaceWords {
        static class TrieNode {
            String word;
            TrieNode[] next = new TrieNode[26];
        }

        @Override
        public String replaceWords(List<String> dict, String sentence) {
            TrieNode trie = new TrieNode();
            for (String word : dict) {
                TrieNode node = trie;
                for (int i = 0; i < word.length(); i++) {
                    int x = word.charAt(i) - 'a';
                    if (node.next[x] == null) {
                        node.next[x] = new TrieNode();
                    }
                    node = node.next[x];
                }
                node.word = word;
            }

            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                TrieNode node = trie;
                for (int j = 0; j < word.length() && node != null && node.word == null; j++) {
                    int x = word.charAt(j) - 'a';
                    node = node.next[x];
                }
                if (node != null && node.word != null) {
                    words[i] = node.word;
                }
            }

            return String.join(" ", words);
        }
    }
}

class ReplaceWordsTest extends AbstractTest<ReplaceWords> {
}
