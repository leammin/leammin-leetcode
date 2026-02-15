package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 2335. 装满杯子需要的最短总时长
 *
 * <p>现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 <code>2</code> 杯 <strong>不同</strong> 类型的水或者 <code>1</code> 杯任意类型的水。</p>
 *
 * <p>给你一个下标从 <strong>0</strong> 开始、长度为 <code>3</code> 的整数数组 <code>amount</code> ，其中 <code>amount[0]</code>、<code>amount[1]</code> 和 <code>amount[2]</code> 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 <strong>最少</strong> 秒数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>amount = [1,4,2]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯温水。
 * 第 2 秒：装满一杯温水和一杯热水。
 * 第 3 秒：装满一杯温水和一杯热水。
 * 第 4 秒：装满一杯温水。
 * 可以证明最少需要 4 秒才能装满所有杯子。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>amount = [5,4,4]
 * <strong>输出：</strong>7
 * <strong>解释：</strong>下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯热水。
 * 第 2 秒：装满一杯冷水和一杯温水。
 * 第 3 秒：装满一杯冷水和一杯温水。
 * 第 4 秒：装满一杯温水和一杯热水。
 * 第 5 秒：装满一杯冷水和一杯热水。
 * 第 6 秒：装满一杯冷水和一杯温水。
 * 第 7 秒：装满一杯热水。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>amount = [5,0,0]
 * <strong>输出：</strong>5
 * <strong>解释：</strong>每秒装满一杯冷水。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>amount.length == 3</code></li>
 * 	<li><code>0 &lt;= amount[i] &lt;= 100</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-12
 */
public interface MinimumAmountOfTimeToFillCups {
    int fillCups(int[] amount);

    static Testsuite<MinimumAmountOfTimeToFillCups> testsuite() {
        return Testsuite.<MinimumAmountOfTimeToFillCups>builder()
                .addExpected(t -> t.fillCups(new int[]{1,4,2}), 4)
                .addExpected(t -> t.fillCups(new int[]{5,4,4}), 7)
                .addExpected(t -> t.fillCups(new int[]{5,0,0}), 5)
                .build();
    }


    class Solution implements MinimumAmountOfTimeToFillCups {
        @Override
        public int fillCups(int[] amount) {
            int a, b, c;
            if (amount[0] > amount[1]) {
                a = amount[0];
                c = b = amount[1];
            } else {
                a = amount[1];
                c = b = amount[0];
            }
            if (amount[2] > a) {
                b = a;
                a = amount[2];
            } else if (amount[2] < b) {
                c = amount[2];
            } else {
                b = amount[2];
            }
            return c + b > a ? (c + b - a + 1) / 2 + a : a;
        }
    }
}

class MinimumAmountOfTimeToFillCupsTest extends AbstractTest<MinimumAmountOfTimeToFillCups> {
}
