package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * <div><p>给定一个非负整数&nbsp;<em>numRows，</em>生成杨辉三角的前&nbsp;<em>numRows&nbsp;</em>行。</p>
 *
 * <p><img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif"></p>
 *
 * <p><small>在杨辉三角中，每个数是它左上方和右上方的数的和。</small></p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 5
 * <strong>输出:</strong>
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-27
 */
public interface PascalTriangle {
    List<List<Integer>> generate(int numRows);

    class Solution implements PascalTriangle {
        @Override
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>(numRows);
            List<Integer> last = new ArrayList<>(1);
            last.add(1);
            res.add(last);
            for (int i = 1; i < numRows; i++) {
                List<Integer> cur = new ArrayList<>(i + 1);
                cur.add(1);
                for (int j = 1; j < last.size(); j++) {
                    cur.add(last.get(j) + last.get(j - 1));
                }
                cur.add(1);
                last = cur;
                res.add(cur);
            }
            return res;
        }
    }

}
