package com.leammin.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 
 * <p>给定一个非负索引&nbsp;<em>k</em>，其中 <em>k</em>&nbsp;&le;&nbsp;33，返回杨辉三角的第 <em>k </em>行。</p>
 * 
 * <p><img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif"></p>
 * 
 * <p><small>在杨辉三角中，每个数是它左上方和右上方的数的和。</small></p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong> [1,3,3,1]
 * </pre>
 * 
 * <p><strong>进阶：</strong></p>
 * 
 * <p>你可以优化你的算法到 <em>O</em>(<em>k</em>) 空间复杂度吗？</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-15
 */
public interface PascalsTriangleIi {
    List<Integer> getRow(int rowIndex);

    class Solution implements PascalsTriangleIi {

        @Override
        public List<Integer> getRow(int rowIndex) {
            Integer[] res = new Integer[rowIndex + 1];
            res[0] = 1;
            for (int i = 1; i <= rowIndex; i++) {
                int last = 1;
                for (int j = 1; j < i; j++) {
                    int s = res[j] + last;
                    last = res[j];
                    res[j] = s;
                }
                res[i] = 1;
            }
            return Arrays.asList(res);
        }
    }
}
