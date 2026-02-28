package com.leammin.leetcode.hard;


import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 57. 插入区间
 *
 * <p>给出一个<em>无重叠的 ，</em>按照区间起始端点排序的区间列表。</p>
 *
 * <p>在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> intervals = [[1,3],[6,9]], newInterval = [2,5]
 * <strong>输出:</strong> [[1,5],[6,9]]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> intervals = <code>[[1,2],[3,5],[6,7],[8,10],[12,16]]</code>, newInterval = <code>[4,8]</code>
 * <strong>输出:</strong> [[1,2],[3,10],[12,16]]
 * <strong>解释:</strong> 这是因为新的区间 <code>[4,8]</code> 与 <code>[3,5],[6,7],[8,10]</code>&nbsp;重叠。
 * </pre>
 *
 *
 * @author Leammin
 * @date 2020-11-04
 */
public interface InsertInterval {
    int[][] insert(int[][] intervals, int[] newInterval);

    static Testsuite<InsertInterval> testsuite() {
        return Testsuite.<InsertInterval>builder()
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}),
                        new int[][]{{1, 5}, {6, 9}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8}), new int[][]{{1, 2}, {3, 10}, {12, 16}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{},
                        new int[]{5, 7}), new int[][]{{5, 7}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{2, 3}), new int[][]{{1, 5}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{6, 8}), new int[][]{{1, 5}, {6, 8}}))
                .add(ExpectedTestcase.of(t -> t.insert(new int[][]{{1, 5}},
                        new int[]{0, 0}), new int[][]{{0, 0}, {1, 5}}))
                .build();
    }


    class Solution implements InsertInterval {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length == 0) {
                return new int[][]{newInterval};
            }
            List<int[]> result = new ArrayList<>(intervals.length + 1);
            int[] merge = null;
            boolean merged = false;
            for (int[] interval : intervals) {
                if (merged || (merge == null && interval[1] < newInterval[0])) {
                    result.add(interval);
                } else if (merge == null) {
                    if (newInterval[1] < interval[0]) {
                        merged = true;
                        result.add(newInterval);
                        result.add(interval);
                    } else {
                        merge = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
                    }
                } else if (merge[1] < interval[0]) {
                    merged = true;
                    result.add(merge);
                    result.add(interval);
                } else {
                    merge[1] = Math.max(interval[1], newInterval[1]);
                }
            }
            if (!merged) {
                result.add(merge == null ? newInterval : merge);
            }
            return result.toArray(int[][]::new);
        }
    }
}

class InsertIntervalTest extends AbstractTest<InsertInterval> {
}
