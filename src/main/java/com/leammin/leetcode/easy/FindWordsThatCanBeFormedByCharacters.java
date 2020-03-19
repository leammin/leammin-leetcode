package com.leammin.leetcode.easy;

/**
 * 1160. 拼写单词
 * 
 * <p>给你一份『词汇表』（字符串数组）&nbsp;<code>words</code>&nbsp;和一张『字母表』（字符串）&nbsp;<code>chars</code>。</p>
 * 
 * <p>假如你可以用&nbsp;<code>chars</code>&nbsp;中的『字母』（字符）拼写出 <code>words</code>&nbsp;中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。</p>
 * 
 * <p>注意：每次拼写时，<code>chars</code> 中的每个字母都只能用一次。</p>
 * 
 * <p>返回词汇表&nbsp;<code>words</code>&nbsp;中你掌握的所有单词的 <strong>长度之和</strong>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>words = [&quot;cat&quot;,&quot;bt&quot;,&quot;hat&quot;,&quot;tree&quot;], chars = &quot;atach&quot;
 * <strong>输出：</strong>6
 * <strong>解释： </strong>
 * 可以形成字符串 &quot;cat&quot; 和 &quot;hat&quot;，所以答案是 3 + 3 = 6。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>words = [&quot;hello&quot;,&quot;world&quot;,&quot;leetcode&quot;], chars = &quot;welldonehoneyr&quot;
 * <strong>输出：</strong>10
 * <strong>解释：</strong>
 * 可以形成字符串 &quot;hello&quot; 和 &quot;world&quot;，所以答案是 5 + 5 = 10。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= words[i].length, chars.length&nbsp;&lt;= 100</code></li>
 * 	<li>所有字符串中都仅包含小写英文字母</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-03-17
 */
public interface FindWordsThatCanBeFormedByCharacters {
    int countCharacters(String[] words, String chars);

    class Solution implements FindWordsThatCanBeFormedByCharacters {

        @Override
        public int countCharacters(String[] words, String chars) {
            int[] charCount = new int[26];
            for (int i = 0; i < chars.length(); i++) {
                charCount[chars.charAt(i) - 'a']++;
            }
            int result = 0;
            for (String word : words) {
                boolean found = true;
                int[] count = charCount.clone();
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (count[index] > 0) {
                        count[index]--;
                    } else {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    result += word.length();
                }
            }
            return result;
        }
    }
}