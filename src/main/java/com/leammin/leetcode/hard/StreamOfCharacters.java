package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/stream-of-characters/">1032. 字符流</a>
 *
 * <p>设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 <code>words</code> 中的一个字符串。</p>
 *
 * <p>例如，<code>words = ["abc", "xyz"]</code> 且字符流中逐个依次加入 4 个字符 <code>'a'</code>、<code>'x'</code>、<code>'y'</code> 和 <code>'z'</code> ，你所设计的算法应当可以检测到&nbsp;<code>"axyz"</code> 的后缀 <code>"xyz"</code> 与&nbsp;<code>words</code> 中的字符串 <code>"xyz"</code> 匹配。</p>
 *
 * <p>按下述要求实现 <code>StreamChecker</code> 类：</p>
 *
 * <ul>
 * 	<li><code>StreamChecker(String[] words)</code> ：构造函数，用字符串数组&nbsp;<code>words</code> 初始化数据结构。</li>
 * 	<li><code>boolean query(char letter)</code>：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 <code>words</code> 中的某一字符串，返回 <code>true</code> ；否则，返回 <code>false</code>。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * <strong>输出：</strong>
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 *
 * <strong>解释：</strong>
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= words.length &lt;= 2000</code></li>
 * 	<li><code>1 &lt;= words[i].length &lt;= 200</code></li>
 * 	<li><code>words[i]</code> 由小写英文字母组成</li>
 * 	<li><code>letter</code> 是一个小写英文字母</li>
 * 	<li>最多调用查询 <code>4 * 10<sup>4</sup></code> 次</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-24
 */
public abstract class StreamOfCharacters {

    public StreamOfCharacters(String[] words) {

    }

    abstract boolean query(char letter);

    static Testsuite<StreamOfCharacters> testsuite() {
        return Testsuite.<StreamOfCharacters>builder()
                .add(new Testcase<>() {
                    @Override
                    public StreamOfCharacters solution(Class<? extends StreamOfCharacters> clazz) throws ReflectiveOperationException {
                        return clazz.getConstructor(String[].class).newInstance((Object) new String[]{"cd", "f", "kl"});
                    }

                    @Override
                    public long test(StreamOfCharacters solution) {
                        Assertions.assertThat(solution.query('a')).isFalse();
                        Assertions.assertThat(solution.query('b')).isFalse();
                        Assertions.assertThat(solution.query('c')).isFalse();
                        Assertions.assertThat(solution.query('d')).isTrue();
                        Assertions.assertThat(solution.query('e')).isFalse();
                        Assertions.assertThat(solution.query('f')).isTrue();
                        Assertions.assertThat(solution.query('g')).isFalse();
                        Assertions.assertThat(solution.query('h')).isFalse();
                        Assertions.assertThat(solution.query('i')).isFalse();
                        Assertions.assertThat(solution.query('j')).isFalse();
                        Assertions.assertThat(solution.query('k')).isFalse();
                        Assertions.assertThat(solution.query('l')).isTrue();
                        return 0;
                    }
                })
                .build();
    }

    static class StreamChecker extends StreamOfCharacters {

        static class TreeNode {
            char c;
            boolean end;
            TreeNode[] children = new TreeNode[26];

            TreeNode(char c) {
                this.c = c;
            }
        }

        TreeNode root = new TreeNode(' ');
        char[] buff = new char[200];
        int size = 0;

        public StreamChecker(String[] words) {
            super(words);
            for (String word : words) {
                TreeNode tree = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    int idx = c - 'a';
                    if (tree.children[idx] == null) {
                        tree.children[idx] = new TreeNode(c);
                    }
                    tree = tree.children[idx];
                }
                tree.end = true;
            }
        }

        @Override
        boolean query(char letter) {
            buff[(size++) % 200] = letter;
            TreeNode tree = root;
            for (int i = 0; i < 200 && i < size; i++) {
                char c = buff[(size - 1 - i) % 200];
                TreeNode child = tree.children[c - 'a'];
                if (child == null) {
                    return false;
                }
                if (child.end) {
                    return true;
                }
                tree = child;
            }
            return false;
        }
    }
}

class StreamOfCharactersTest extends AbstractTest<StreamOfCharacters> {
}
