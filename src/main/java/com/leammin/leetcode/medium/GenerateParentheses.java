package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 22. 括号生成
 *
 * <p>给出&nbsp;<em>n</em>&nbsp;代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且<strong>有效的</strong>括号组合。</p>
 *
 * <p>例如，给出&nbsp;<em>n </em>=<em> </em>3，生成结果为：</p>
 *
 * <pre>[
 *   &quot;((()))&quot;,
 *   &quot;(()())&quot;,
 *   &quot;(())()&quot;,
 *   &quot;()(())&quot;,
 *   &quot;()()()&quot;
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2020-03-21
 */
public interface GenerateParentheses {
    List<String> generateParenthesis(int n);

    static Testsuite<GenerateParentheses> testsuite() {
        return Testsuite.<GenerateParentheses>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.generateParenthesis(3), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        "((()))", "(()())", "(())()", "()(())", "()()()"
                        )
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.generateParenthesis(4), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        "(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())",
                        "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"
                        )
                ))
                .build();
    }


    class Solution implements GenerateParentheses {
        List<char[]> res;

        @Override
        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            char[] init = new char[n * 2];
            res.add(init);
            generateParenthesis(init, 0, 0);
            List<String> ans = new ArrayList<>();
            for (char[] re : res) {
                ans.add(String.valueOf(re));
            }
            return ans;
        }

        private void generateParenthesis(char[] chars, int left, int right) {
            if (left == chars.length / 2) {
                Arrays.fill(chars, left + right, chars.length, ')');
                return;
            }
            if (left > right) {
                char[] cloned = chars.clone();
                res.add(cloned);
                cloned[left + right] = ')';
                generateParenthesis(cloned, left, right + 1);
            }
            chars[left + right] = '(';
            generateParenthesis(chars, left + 1, right);
        }
    }
}

class GenerateParenthesesTest extends AbstractTest<GenerateParentheses> {
}
