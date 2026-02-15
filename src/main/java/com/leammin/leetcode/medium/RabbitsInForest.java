package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 781. 森林中的兔子
 * 
 * <p>森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在&nbsp;<code>answers</code>&nbsp;数组里。</p>
 * 
 * <p>返回森林中兔子的最少数量。</p>
 * 
 * <pre>
 * <strong>示例:</strong>
 * <strong>输入:</strong> answers = [1, 1, 2]
 * <strong>输出:</strong> 5
 * <strong>解释:</strong>
 * 两只回答了 &quot;1&quot; 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 &quot;2&quot; 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 &quot;2&quot; 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * 
 * <strong>输入:</strong> answers = [10, 10, 10]
 * <strong>输出:</strong> 11
 * 
 * <strong>输入:</strong> answers = []
 * <strong>输出:</strong> 0
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li><code>answers</code>&nbsp;的长度最大为<code>1000</code>。</li>
 * 	<li><code>answers[i]</code>&nbsp;是在&nbsp;<code>[0, 999]</code>&nbsp;范围内的整数。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-04-04
 */
public interface RabbitsInForest {
    int numRabbits(int[] answers);

    static Testsuite<RabbitsInForest> testsuite() {
        return Testsuite.<RabbitsInForest>builder()
                .addExpected(t -> t.numRabbits(new int[]{1, 1, 2}), 5)
                .addExpected(t -> t.numRabbits(new int[]{10, 10, 10}), 11)
                .addExpected(t -> t.numRabbits(new int[]{}), 0)
                .build();
    }


    class Solution implements RabbitsInForest {

        @Override
        public int numRabbits(int[] answers) {
            if (answers.length == 0) {
                return 0;
            }
            int[] count = new int[1000];
            for (int answer : answers) {
                count[answer]++;
            }
            int res = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    res += (((count[i] - 1) / (i + 1)) + 1) * (i + 1);
                }
            }
            return res;
        }
    }
}

class RabbitsInForestTest extends AbstractTest<RabbitsInForest> {
}
