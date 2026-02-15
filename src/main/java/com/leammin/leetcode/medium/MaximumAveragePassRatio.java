package com.leammin.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

/**
 * 1792. 最大平均通过率
 *
 * <p>一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 <code>classes</code> ，其中 <code>classes[i] = [pass<sub>i</sub>, total<sub>i</sub>]</code> ，表示你提前知道了第 <code>i</code> 个班级总共有 <code>total<sub>i</sub></code> 个学生，其中只有 <code>pass<sub>i</sub></code> 个学生可以通过考试。</p>
 *
 * <p>给你一个整数 <code>extraStudents</code> ，表示额外有 <code>extraStudents</code> 个聪明的学生，他们 <strong>一定</strong> 能通过任何班级的期末考。你需要给这 <code>extraStudents</code> 个学生每人都安排一个班级，使得 <strong>所有</strong> 班级的 <strong>平均</strong> 通过率 <strong>最大</strong> 。</p>
 *
 * <p>一个班级的 <strong>通过率</strong> 等于这个班级通过考试的学生人数除以这个班级的总人数。<strong>平均通过率</strong> 是所有班级的通过率之和除以班级数目。</p>
 *
 * <p>请你返回在安排这 <code><span style="">extraStudents</span></code> 个学生去对应班级后的 <strong>最大</strong> 平均通过率。与标准答案误差范围在 <code>10<sup>-5</sup></code> 以内的结果都会视为正确结果。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <b>输入：</b>classes = [[1,2],[3,5],[2,2]], <code>extraStudents</code> = 2
 * <b>输出：</b>0.78333
 * <b>解释：</b>你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <b>输入：</b>classes = [[2,4],[3,9],[4,5],[2,10]], <code>extraStudents</code> = 4
 * <strong>输出：</strong>0.53485
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= classes.length <= 10<sup>5</sup></code></li>
 * 	<li><code>classes[i].length == 2</code></li>
 * 	<li><code>1 <= pass<sub>i</sub> <= total<sub>i</sub> <= 10<sup>5</sup></code></li>
 * 	<li><code>1 <= extraStudents <= 10<sup>5</sup></code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-19
 */
public interface MaximumAveragePassRatio {
    double maxAverageRatio(int[][] classes, int extraStudents);

    static Testsuite<MaximumAveragePassRatio> testsuite() {
        return Testsuite.<MaximumAveragePassRatio>builder()
                .addConsumer(t -> t.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2),
                        output -> Assertions.assertThat(output).isCloseTo(0.78333, Offset.offset(0.00001)))
                .addConsumer(t -> t.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4),
                        output -> Assertions.assertThat(output).isCloseTo(0.53485, Offset.offset(0.00001)))
                .build();
    }


    class Solution implements MaximumAveragePassRatio {

        @Override
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            double sumRate = 0;
            double[] rateDiff = new double[classes.length];
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(i -> -rateDiff[i]));
            for (int i = 0; i < classes.length; i++) {
                double rate = classes[i][0] / (double) classes[i][1];
                sumRate += rate;
                rateDiff[i] = (classes[i][0] + 1) / (double) (classes[i][1] + 1) - rate;
                maxHeap.add(i);
            }
            for (int i = 0; i < extraStudents; i++) {
                int rateDiffIdx = maxHeap.poll();
                sumRate += rateDiff[rateDiffIdx];
                classes[rateDiffIdx][0]++;
                classes[rateDiffIdx][1]++;
                int pass = classes[rateDiffIdx][0];
                int total = classes[rateDiffIdx][1];
                rateDiff[rateDiffIdx] = (pass + 1) / (double) (total + 1) - pass / (double) total;
                maxHeap.add(rateDiffIdx);
            }
            return sumRate / classes.length;
        }
    }
}

class MaximumAveragePassRatioTest extends AbstractTest<MaximumAveragePassRatio> {
}
