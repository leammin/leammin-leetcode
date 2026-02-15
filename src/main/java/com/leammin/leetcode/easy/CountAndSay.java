package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 38. 报数
 *
 * <div><p>报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：</p>
 *
 * <pre>1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * </pre>
 *
 * <p><code>1</code>&nbsp;被读作&nbsp;&nbsp;<code>"one 1"</code>&nbsp;&nbsp;(<code>"一个一"</code>) , 即&nbsp;<code>11</code>。<br>
 * <code>11</code> 被读作&nbsp;<code>"two 1s"</code>&nbsp;(<code>"两个一"</code>）, 即&nbsp;<code>21</code>。<br>
 * <code>21</code> 被读作&nbsp;<code>"one 2"</code>, &nbsp;"<code>one 1"</code>&nbsp;（<code>"一个二"</code>&nbsp;,&nbsp;&nbsp;<code>"一个一"</code>)&nbsp;, 即&nbsp;<code>1211</code>。</p>
 *
 * <p>给定一个正整数 <em>n</em>（1 ≤&nbsp;<em>n</em>&nbsp;≤ 30），输出报数序列的第 <em>n</em> 项。</p>
 *
 * <p>注意：整数顺序将表示为一个字符串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> 1
 * <strong>输出:</strong> "1"
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> 4
 * <strong>输出:</strong> "1211"
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-13
 */
public interface CountAndSay {
    String countAndSay(int n);

    static Testsuite<CountAndSay> testsuite() {
        return Testsuite.<CountAndSay>builder()
                .add(ExpectedTestcase.of(t->t.countAndSay(1), "1"))
                .add(ExpectedTestcase.of(t->t.countAndSay(2), "11"))
                .add(ExpectedTestcase.of(t->t.countAndSay(3), "21"))
                .add(ExpectedTestcase.of(t->t.countAndSay(4), "1211"))
                .add(ExpectedTestcase.of(t->t.countAndSay(5), "111221"))
                .build();
    }


    class Solution implements CountAndSay {
        @Override
        public String countAndSay(int n) {
            StringBuilder res = new StringBuilder("1");
            for (int i = 0; i < n - 1; i++) {
                StringBuilder sb = new StringBuilder();
                int index = 0;
                while (index < res.length()) {
                    int same = index + 1;
                    while (same < res.length() && res.charAt(same) == res.charAt(index)) {
                        same++;
                    }
                    int count = same - index;
                    sb.append(same - index).append(res.charAt(index));
                    index = same;
                }
                res = sb;
            }
            return res.toString();
        }
    }

}

class CountAndSayTest extends AbstractTest<CountAndSay> {
}
