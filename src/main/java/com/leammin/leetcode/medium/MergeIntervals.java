package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 
 * <p>给出一个区间的集合，请合并所有重叠的区间。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [[1,3],[2,6],[8,10],[15,18]]
 * <strong>输出:</strong> [[1,6],[8,10],[15,18]]
 * <strong>解释:</strong> 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [[1,4],[4,5]]
 * <strong>输出:</strong> [[1,5]]
 * <strong>解释:</strong> 区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-01
 */
public interface MergeIntervals {
    int[][] merge(int[][] intervals);

    class Solution implements MergeIntervals {

        @Override
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(in -> in[0]));
            List<int[]> ans = new ArrayList<>();
            int last = Integer.MIN_VALUE;
            for (int[] interval : intervals) {
                if (last < interval[0]) {
                    ans.add(interval);
                    last = interval[1];
                } else if (last < interval[1]){
                    ans.get(ans.size() - 1)[1] = interval[1];
                    last = interval[1];
                }
            }
            return ans.toArray(int[][]::new);
        }
    }
}
