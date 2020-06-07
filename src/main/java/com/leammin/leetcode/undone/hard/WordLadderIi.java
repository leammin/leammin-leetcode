package com.leammin.leetcode.undone.hard;

import java.util.*;

/**
 * 126. 单词接龙 II
 *
 * <p>给定两个单词（<em>beginWord</em> 和 <em>endWord</em>）和一个字典 <em>wordList</em>，找出所有从 <em>beginWord </em>到 <em>endWord </em>的最短转换序列。转换需遵循如下规则：</p>
 *
 * <ol>
 * 	<li>每次转换只能改变一个字母。</li>
 * 	<li>转换过程中的中间单词必须是字典中的单词。</li>
 * </ol>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li>如果不存在这样的转换序列，返回一个空列表。</li>
 * 	<li>所有单词具有相同的长度。</li>
 * 	<li>所有单词只由小写字母组成。</li>
 * 	<li>字典中不存在重复的单词。</li>
 * 	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * beginWord = &quot;hit&quot;,
 * endWord = &quot;cog&quot;,
 * wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
 *
 * <strong>输出:</strong>
 * [
 *   [&quot;hit&quot;,&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;cog&quot;],
 * &nbsp; [&quot;hit&quot;,&quot;hot&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
 * ]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * beginWord = &quot;hit&quot;
 * endWord = &quot;cog&quot;
 * wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]
 *
 * <strong>输出: </strong>[]
 *
 * <strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以不存在符合要求的转换序列。</pre>
 *
 * @author Leammin
 * @date 2020-06-07
 */
public interface WordLadderIi {
    List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList);

//    class Solution implements WordLadderIi {
//
//        @Override
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            HashSet<String> wordSet = new HashSet<>(wordList);
//            Set<Character>[] wordChars = new Set[beginWord.length()];
//            for (int i = 0; i < wordChars.length; i++) {
//                wordChars[i] = new HashSet<>();
//            }
//            for (String s : wordSet) {
//                for (int i = 0; i < s.length(); i++) {
//                    wordChars[i].add(s.charAt(i));
//                }
//            }
//
//            int resSize = -1;
//            List<List<String>> res = new ArrayList<>();
//            Queue<List<String>> queue = new LinkedList<>();
//            queue.add(Collections.singletonList(beginWord));
//            while (!queue.isEmpty()) {
//                List<String> words = queue.poll();
//                if (resSize > 0 && words.size() > resSize) {
//                    return res;
//                }
//                HashSet<String> wordsSet = new HashSet<>(words);
//                System.out.println(words);
//                String word = words.get(words.size() - 1);
//                for (int i = 0; i < word.length(); i++) {
//                    for (Character c : wordChars[i]) {
//                        if (c != word.charAt(i)) {
//                            String newWord = replace(word, i, c);
//                            if (!wordsSet.contains(newWord)) {
//                                if (newWord.equals(endWord)) {
//                                    resSize = words.size();
//                                    ArrayList<String> r = new ArrayList<>(words);
//                                    r.add(newWord);
//                                    res.add(r);
//                                } else if (wordSet.contains(newWord)) {
//                                    ArrayList<String> r = new ArrayList<>(words);
//                                    r.add(newWord);
//                                    queue.add(r);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return res;
//        }
//
//        private String replace(String str, int index, char newChar) {
//            char[] chars = str.toCharArray();
//            chars[index] = newChar;
//            return new String(chars);
//        }
//    }

//    class Solution implements WordLadderIi {
//
//        @Override
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            if (beginWord.equals(endWord)) {
//                ArrayList<List<String>> lists = new ArrayList<>();
//                lists.add(new LinkedList<>(Collections.singletonList(beginWord)));
//                return lists;
//            }
//            List<String> diff1 = new ArrayList<>();
//            List<String> diff2 = new ArrayList<>();
//            for (String s : wordList) {
//                int diff = diff(s, beginWord);
//                if (diff == 1) {
//                    diff1.add(s);
//                } else if (diff > 1) {
//                    diff2.add(s);
//                }
//            }
//            List<List<String>> res = new ArrayList<>();
//            for (String s : diff1) {
//                res.addAll(findLadders(s, endWord, diff2));
//            }
//            for (List<String> re : res) {
//                re.add(0, beginWord);
//            }
//            return res;
//        }
//
//        private int diff(String a, String b) {
//            int diff = 0;
//            for (int i = 0; i < a.length(); i++) {
//                if (a.charAt(i) != b.charAt(i)) {
//                    if (++diff > 1) {
//                        return diff;
//                    }
//                }
//            }
//            return diff;
//        }
//    }

    /**
     * 15.98%
     * 90.00%
     */
    class Solution2 implements WordLadderIi {

        @Override
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return findLadders(Collections.singleton(beginWord), endWord, wordList);
        }

        public List<List<String>> findLadders(Set<String> beginWord, String endWord, List<String> wordList) {
            if (beginWord.isEmpty()) {
                return new ArrayList<>();
            }
            if (beginWord.contains(endWord)) {
                ArrayList<List<String>> lists = new ArrayList<>();
                lists.add(new ArrayList<>(Collections.singletonList(endWord)));
                return lists;
            }
            Set<String> newBeginWord = new HashSet<>();
            List<String> newWordList = new ArrayList<>();
            for (String s : wordList) {
                int diff = 0;
                if (!beginWord.contains(s)) {
                    for (String b : beginWord) {
                        if ((diff = diff(s, b)) == 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    newBeginWord.add(s);
                } else if (diff > 1) {
                    newWordList.add(s);
                }
            }
            List<List<String>> res = new ArrayList<>();
            List<List<String>> ladders = findLadders(newBeginWord, endWord, newWordList);
            for (List<String> l : ladders) {
                String s = l.get(0);
                for (String b : beginWord) {
                    if (diff(s, b) == 1) {
                        ArrayList<String> re = new ArrayList<>(l.size() + 1);
                        re.add(b);
                        re.addAll(l);
                        res.add(re);
                    }
                }
            }
            return res;
        }

        private int diff(String a, String b) {
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (++diff > 1) {
                        return diff;
                    }
                }
            }
            return diff;
        }
    }
}
