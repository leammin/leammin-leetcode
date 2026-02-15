package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/brace-expansion-ii/">1096. 花括号展开 II</a>
 *
 * <p>如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。</p>
 *
 * <p>花括号展开的表达式可以看作一个由 <strong>花括号</strong>、<strong>逗号</strong> 和 <strong>小写英文字母</strong> 组成的字符串，定义下面几条语法规则：</p>
 *
 * <ul>
 * 	<li>如果只给出单一的元素&nbsp;<code>x</code>，那么表达式表示的字符串就只有&nbsp;<code>"x"</code>。<code>R(x) = {x}</code>
 *
 * 	<ul>
 * 		<li>例如，表达式 <code>"a"</code> 表示字符串 <code>"a"</code>。</li>
 * 		<li>而表达式 <code>"w"</code> 就表示字符串 <code>"w"</code>。</li>
 * 	</ul>
 * 	</li>
 * 	<li>当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。<code>R({e_1,e_2,...}) = R(e_1)&nbsp;∪ R(e_2)&nbsp;∪ ...</code>
 * 	<ul>
 * 		<li>例如，表达式 <code>"{a,b,c}"</code> 表示字符串&nbsp;<code>"a","b","c"</code>。</li>
 * 		<li>而表达式 <code>"{{a,b},{b,c}}"</code> 也可以表示字符串&nbsp;<code>"a","b","c"</code>。</li>
 * 	</ul>
 * 	</li>
 * 	<li>要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。<code>R(e_1 + e_2) = {a + b for (a, b) in&nbsp;R(e_1)&nbsp;× R(e_2)}</code>
 * 	<ul>
 * 		<li>例如，表达式 <code>"{a,b}{c,d}"</code> 表示字符串&nbsp;<code>"ac","ad","bc","bd"</code>。</li>
 * 	</ul>
 * 	</li>
 * 	<li>表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * 	<ul>
 * 		<li>例如，表达式 <code>"a{b,c,d}"</code> 表示字符串&nbsp;<code>"ab","ac","ad"​​​​​​</code>。</li>
 * 		<li>例如，表达式 <code>"a{b,c}{d,e}f{g,h}"</code> 可以表示字符串&nbsp;<code>"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"</code>。</li>
 * 	</ul>
 * 	</li>
 * </ul>
 *
 * <p>给出表示基于给定语法规则的表达式&nbsp;<code>expression</code>，返回它所表示的所有字符串组成的有序列表。</p>
 *
 * <p>假如你希望以「集合」的概念了解此题，也可以通过点击 “<strong>显示英文描述</strong>” 获取详情。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>expression = "{a,b}{c,{d,e}}"
 * <strong>输出：</strong>["ac","ad","ae","bc","bd","be"]</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>expression = "{{a,z},a{b,c},{ab,z}}"
 * <strong>输出：</strong>["a","ab","ac","z"]
 * <strong>解释：</strong>输出中 <strong>不应 </strong>出现重复的组合结果。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= expression.length &lt;= 60</code></li>
 * 	<li><code>expression[i]</code> 由 <code>'{'</code>，<code>'}'</code>，<code>','</code>&nbsp;或小写英文字母组成</li>
 * 	<li>给出的表达式&nbsp;<code>expression</code>&nbsp;用以表示一组基于题目描述中语法构造的字符串</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-07
 */
public interface BraceExpansionIi {
    List<String> braceExpansionII(String expression);

    static Testsuite<BraceExpansionIi> testsuite() {
        return Testsuite.<BraceExpansionIi>builder()
                .addExpected(t -> t.braceExpansionII("c,{d,e}"), List.of("c", "d", "e"))
                .addExpected(t -> t.braceExpansionII("{c,{d,e}}"), List.of("c", "d", "e"))
                .addExpected(t -> t.braceExpansionII("a{c,{d,e}}"), List.of("ac", "ad", "ae"))
                .addExpected(t -> t.braceExpansionII("{a,b}{c,{d,e}}"), List.of("ac", "ad", "ae", "bc", "bd", "be"))
                .addExpected(t -> t.braceExpansionII("{{a,z},a{b,c},{ab,z}}"), List.of("a", "ab", "ac", "z"))
                .addExpected(t -> t.braceExpansionII("a{x,ia,o}w"), List.of("aiaw", "aow", "axw"))
                .addExpected(t -> t.braceExpansionII("a{x,ia,o}w,{y,z}"), List.of("aiaw", "aow", "axw", "y", "z"))
                .addExpected(t -> t.braceExpansionII("{a{x,ia,o}w,{n,{g,{u,o}},{a,{x,ia,o},w}},er}"), List.of("a", "aiaw", "aow", "axw", "er", "g", "ia", "n", "o", "u", "w", "x"))
                .build();
    }

    class Solution implements BraceExpansionIi {

        @Override
        public List<String> braceExpansionII(String expression) {
            List<String> res = brace(expression.toCharArray(), 0, expression.length());
            TreeSet<String> set = new TreeSet<>(res);
            return List.copyOf(set);
        }

        private List<String> brace(char[] expr, int start, int end) {
            List<String> res = new ArrayList<>();
            List<int[]> parts = split(expr, start, end);
            for (int[] part : parts) {
                List<int[]> elements = splitPart(expr, part[0], part[1]);
                List<String> t = Collections.emptyList();
                for (int[] ele : elements) {
                    if (ele[2] == 1) {
                        t = append(t, Collections.singletonList(String.valueOf(expr, ele[0], ele[1] - ele[0])));
                    } else {
                        t = append(t, brace(expr, ele[0], ele[1]));
                    }
                }
                res.addAll(t);
            }
            return res;
        }

        private List<String> append(List<String> left, List<String> right) {
            if (left.isEmpty()) {
                return right;
            }
            List<String> res = new ArrayList<>(left.size() * right.size());
            for (String l : left) {
                for (String r : right) {
                    res.add(l + r);
                }
            }
            return res;
        }

        private List<int[]> split(char[] expr, int start, int end) { // {start, end}
            List<int[]> res = new ArrayList<>();

            int last = start;
            int lbc = 0;
            for (int i = start; i < end; i++) {
                if (expr[i] == '{') {
                    lbc++;
                    continue;
                }
                if (expr[i] == '}') {
                    lbc--;
                    continue;
                }
                if (lbc == 0 && expr[i] == ',') {
                    res.add(new int[]{last, i});
                    last = i + 1;
                }
            }
            res.add(new int[]{last, end});
            return res;
        }

        private List<int[]> splitPart(char[] expr, int start, int end) { // {start, end, type}
            List<int[]> res = new ArrayList<>();
            int c = 0;
            int lb = -1;
            int lbc = 0;
            for (int i = start; i < end; i++) {
                if (expr[i] >= 'a' && expr[i] <= 'z') {
                    if (lbc == 0) {
                        c++;
                    }
                } else if (expr[i] == '{') {
                    if (lbc == 0 && c > 0) {
                        res.add(new int[]{i - c, i, 1});
                        c = 0;
                    }
                    if (lbc == 0) {
                        lb = i;
                    }
                    lbc++;
                } else if (expr[i] == '}') {
                    lbc--;
                    if (lbc == 0) {
                        res.add(new int[]{lb + 1, i, 2});
                    }
                }

            }
            if (c > 0) {
                res.add(new int[]{end - c, end, 1});
            }
            return res;
        }
    }
}

class BraceExpansionIiTest extends AbstractTest<BraceExpansionIi> {
}
