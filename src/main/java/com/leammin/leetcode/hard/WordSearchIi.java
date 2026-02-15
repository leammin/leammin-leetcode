package com.leammin.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 212. 单词搜索 II
 * 
 * <p>给定一个二维网格&nbsp;<strong>board&nbsp;</strong>和一个字典中的单词列表 <strong>words</strong>，找出所有同时在二维网格和字典中出现的单词。</p>
 * 
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中&ldquo;相邻&rdquo;单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> 
 * <strong>words</strong> = <code>[&quot;oath&quot;,&quot;pea&quot;,&quot;eat&quot;,&quot;rain&quot;]</code> and <strong>board </strong>=
 * [
 *   [&#39;<strong>o</strong>&#39;,&#39;<strong>a</strong>&#39;,&#39;a&#39;,&#39;n&#39;],
 *   [&#39;e&#39;,&#39;<strong>t</strong>&#39;,&#39;<strong>a</strong>&#39;,&#39;<strong>e</strong>&#39;],
 *   [&#39;i&#39;,&#39;<strong>h</strong>&#39;,&#39;k&#39;,&#39;r&#39;],
 *   [&#39;i&#39;,&#39;f&#39;,&#39;l&#39;,&#39;v&#39;]
 * ]
 * 
 * <strong>输出:&nbsp;</strong><code>[&quot;eat&quot;,&quot;oath&quot;]</code></pre>
 * 
 * <p><strong>说明:</strong><br>
 * 你可以假设所有输入都由小写字母 <code>a-z</code>&nbsp;组成。</p>
 * 
 * <p><strong>提示:</strong></p>
 * 
 * <ul>
 * 	<li>你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？</li>
 * 	<li>如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： <a href="/problems/implement-trie-prefix-tree/description/">实现Trie（前缀树）</a>。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-05-06
 */
public interface WordSearchIi {
    List<String> findWords(char[][] board, String[] words);

    static Testsuite<WordSearchIi> testsuite() {
        return Testsuite.<WordSearchIi>builder()
            .addConsumer(t -> t.findWords(
                new char[][] {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[] {"oath", "pea", "eat", "rain"}),
                out -> Assertions.assertThat(out).containsExactlyInAnyOrder("oath", "eat"))
            .build();
    }


    class Solution implements WordSearchIi {
        class DictTreeNode {
            Map<Character, DictTreeNode> children = new HashMap<>(32);
            String word;
            char c;
            DictTreeNode parent;
            DictTreeNode(char c, DictTreeNode parent) {
                this.c = c;
                this.parent = parent;
            }
        }

        @Override
        public List<String> findWords(char[][] board, String[] words) {
            DictTreeNode root = new DictTreeNode((char)0, null);
            for(String w : words) {
                DictTreeNode node = root;
                for(int i = 0; i < w.length(); i++) {
                    char c = w.charAt(i);
                    DictTreeNode parent = node;
                    node = node.children.computeIfAbsent(c, k -> new DictTreeNode(c, parent));
                }
                node.word = w;
            }
            List<String> result = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    dfs(result, board, i, j, root, root);
                }
            }
            return result;
        }

        private void dfs(List<String> result, char[][] board, int i, int j, DictTreeNode root, DictTreeNode cur) {
            if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 0 || root.children.isEmpty() || cur.children.isEmpty()) {
                return;
            }
            DictTreeNode node = cur.children.get(board[i][j]);
            if(node == null) {
                return;
            }
            if(node.word != null) {
                result.add(node.word);

                // 剪枝
                node.word = null;
                DictTreeNode pa = cur;
                DictTreeNode ch = node;
                while(pa != null && ch.children.isEmpty()) {
                    pa.children.remove(ch.c);
                    ch = pa;
                    pa = pa.parent;
                }
            }
            char c = board[i][j];
            board[i][j] = 0;
            dfs(result, board, i + 1, j, root, node);
            dfs(result, board, i, j + 1, root, node);
            dfs(result, board, i - 1, j, root, node);
            dfs(result, board, i, j - 1, root, node);
            board[i][j] = c;
        }
    }
}

class WordSearchIiTest extends AbstractTest<WordSearchIi> {
}
