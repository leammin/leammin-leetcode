package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 *
 * <div><p>假设你正在爬楼梯。需要 <em>n</em>&nbsp;阶你才能到达楼顶。</p>
 *
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 *
 * <p><strong>注意：</strong>给定 <em>n</em> 是一个正整数。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong> 2
 * <strong>输出：</strong> 2
 * <strong>解释：</strong> 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong> 3
 * <strong>输出：</strong> 3
 * <strong>解释：</strong> 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-08-31
 */
public interface ClimbingStairs {
    int climbStairs(int n);

    class Solution implements ClimbingStairs {
        private Map<Integer, Integer> res = new HashMap<>();

        @Override
        public int climbStairs(int n) {
            Integer r = res.get(n);
            if (r != null) {
                return r;
            }
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n < 1) {
                return 0;
            }
            int r1 = climbStairs(n - 1);
            int r2 = climbStairs(n - 2);
            res.put(n - 1, r1);
            res.put(n - 2, r2);
            return r1 + r2;
        }
    }


}
