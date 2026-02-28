package com.leammin.leetcode.hard;


import java.util.*;
import java.util.stream.Collectors;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.List;

/**
 * 1178. 猜字谜
 * 
 * <p>外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。</p>
 * 
 * <p>字谜的迷面&nbsp;<code>puzzle</code> 按字符串形式给出，如果一个单词&nbsp;<code>word</code>&nbsp;符合下面两个条件，那么它就可以算作谜底：</p>
 * 
 * <ul>
 * 	<li>单词&nbsp;<code>word</code>&nbsp;中包含谜面&nbsp;<code>puzzle</code>&nbsp;的第一个字母。</li>
 * 	<li>单词&nbsp;<code>word</code>&nbsp;中的每一个字母都可以在谜面&nbsp;<code>puzzle</code>&nbsp;中找到。<br>
 * 	例如，如果字谜的谜面是 &quot;abcdefg&quot;，那么可以作为谜底的单词有 &quot;faced&quot;, &quot;cabbage&quot;, 和 &quot;baggage&quot;；而 &quot;beefed&quot;（不含字母 &quot;a&quot;）以及&nbsp;&quot;based&quot;（其中的 &quot;s&quot; 没有出现在谜面中）。</li>
 * </ul>
 * 
 * <p>返回一个答案数组&nbsp;<code>answer</code>，数组中的每个元素&nbsp;<code>answer[i]</code>&nbsp;是在给出的单词列表 <code>words</code> 中可以作为字谜迷面&nbsp;<code>puzzles[i]</code>&nbsp;所对应的谜底的单词数目。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre><strong>输入：</strong>
 * words = [&quot;aaaa&quot;,&quot;asas&quot;,&quot;able&quot;,&quot;ability&quot;,&quot;actt&quot;,&quot;actor&quot;,&quot;access&quot;], 
 * puzzles = [&quot;aboveyz&quot;,&quot;abrodyz&quot;,&quot;abslute&quot;,&quot;absoryz&quot;,&quot;actresz&quot;,&quot;gaswxyz&quot;]
 * <strong>输出：</strong>[1,1,3,2,4,0]
 * <strong>解释：</strong>
 * 1 个单词可以作为 &quot;aboveyz&quot; 的谜底 : &quot;aaaa&quot; 
 * 1 个单词可以作为 &quot;abrodyz&quot; 的谜底 : &quot;aaaa&quot;
 * 3 个单词可以作为 &quot;abslute&quot; 的谜底 : &quot;aaaa&quot;, &quot;asas&quot;, &quot;able&quot;
 * 2 个单词可以作为&nbsp;&quot;absoryz&quot; 的谜底 : &quot;aaaa&quot;, &quot;asas&quot;
 * 4 个单词可以作为&nbsp;&quot;actresz&quot; 的谜底 : &quot;aaaa&quot;, &quot;asas&quot;, &quot;actt&quot;, &quot;access&quot;
 * 没有单词可以作为&nbsp;&quot;gaswxyz&quot; 的谜底，因为列表中的单词都不含字母 &#39;g&#39;。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= words.length &lt;= 10^5</code></li>
 * 	<li><code>4 &lt;= words[i].length &lt;= 50</code></li>
 * 	<li><code>1 &lt;= puzzles.length &lt;= 10^4</code></li>
 * 	<li><code>puzzles[i].length == 7</code></li>
 * 	<li><code>words[i][j]</code>, <code>puzzles[i][j]</code>&nbsp;都是小写英文字母。</li>
 * 	<li>每个&nbsp;<code>puzzles[i]</code>&nbsp;所包含的字符都不重复。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-26
 */
public interface NumberOfValidWordsForEachPuzzle {
    List<Integer> findNumOfValidWords(String[] words, String[] puzzles);

    static Testsuite<NumberOfValidWordsForEachPuzzle> testsuite() {
        return Testsuite.<NumberOfValidWordsForEachPuzzle>builder()
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                        new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}),
                        List.of(1, 1, 3, 2, 4, 0)))
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"apple", "pleas", "please"},
                        new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}),
                        List.of(0, 1, 3, 2, 0)))
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"kkaz", "kaaz", "aazk", "aaaz", "abcdefghijklmnopqrstuvwxyz", "kkka", "kkkz", "aaaa", "kkkk", "zzzz"},
                        new String[]{"kazxyuv"}),
                        List.of(6)))
                .build();
    }


    class Solution implements NumberOfValidWordsForEachPuzzle {

        @Override
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            List<Integer> res = new ArrayList<>(puzzles.length);
            for (String puzzle : puzzles) {
                int c = 0;
                for (String word : words) {
                    if (word.contains(puzzle.charAt(0) + "")) {
                        boolean containAll = true;
                        for (int j = 0; j < word.length(); j++) {
                            if (!puzzle.contains(word.charAt(j) + "")) {
                                containAll = false;
                                break;
                            }
                        }
                        if (containAll) {
                            c++;
                        }
                    }
                }
                res.add(c);
            }
            return res;
        }
    }

    class Solution2 implements NumberOfValidWordsForEachPuzzle {

        @SuppressWarnings("unchecked")
        @Override
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            int[][] puzzleCount = new int[puzzles.length][26];
            for (int i = 0; i < puzzles.length; i++) {
                for (int j = 0; j < puzzles[i].length(); j++) {
                    puzzleCount[i][puzzles[i].charAt(j) - 'a']++;
                }
            }
            Set<Character>[] wordCharSets = new Set[words.length];
            for (int i = 0; i < words.length; i++) {
                wordCharSets[i] = new HashSet<>();
                for (int j = 0; j < words[i].length(); j++) {
                    wordCharSets[i].add(words[i].charAt(j));
                }
            }
            List<Integer> res = new ArrayList<>(puzzles.length);
            for (int i = 0; i < puzzles.length; i++) {
                char first = puzzles[i].charAt(0);
                int c = 0;
                for (Set<Character> word : wordCharSets) {
                    if (word.contains(first)) {
                        boolean containAll = true;
                        for (char wc : word) {
                            if (puzzleCount[i][wc - 'a'] == 0) {
                                containAll = false;
                                break;
                            }
                        }
                        if (containAll) {
                            c++;
                        }
                    }
                }
                res.add(c);
            }
            return res;
        }
    }

    class Solution3 implements NumberOfValidWordsForEachPuzzle {

        @Override
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            WordTree wordTree = buildTree(words);
            List<Integer> res = new ArrayList<>(puzzles.length);
            for (int i = 0; i < puzzles.length; i++) {
                char[] puzzleChars = puzzles[i].toCharArray();
                Arrays.sort(puzzleChars);
                res.add(countWord(puzzleChars, 0, puzzles[i].charAt(0), wordTree));
            }
            return res;
        }

        private int countWord(char[] puzzleChars, int offset, char first, WordTree wordTree) {
            int count = 0;
            for (int i = offset; i < puzzleChars.length; i++) {
                WordTree tree = wordTree.next[puzzleChars[i] - 'a'];
                if (tree != null) {
                    if (first == 0 || first == puzzleChars[i]) {
                        count += tree.count;
                    }
                    count += countWord(puzzleChars, i + 1,  first == puzzleChars[i] ? 0 : first, tree);
                }
            }
            return count;
        }

        private int[] count(String s) {
            int[] c = new int[26];
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i) - 'a']++;
            }
            return c;
        }

        private WordTree buildTree(String[] words) {
            List<int[]> wordCounts = Arrays.stream(words)
                    .map(this::count)
                    .collect(Collectors.toList());
            WordTree wordTree = new WordTree();
            for (int[] wordCount : wordCounts) {
                WordTree node = wordTree;
                for (int i = 0; i < wordCount.length; i++) {
                    if (wordCount[i] > 0) {
                        if (node.next[i] == null) {
                            node.next[i] = new WordTree();
                        }
                        node = node.next[i];
                    }
                }
                node.count++;
            }
            return wordTree;
        }

        static class WordTree {
            int count = 0;
            WordTree[] next = new WordTree[26];
        }
    }
}

class NumberOfValidWordsForEachPuzzleTest extends AbstractTest<NumberOfValidWordsForEachPuzzle> {
}
