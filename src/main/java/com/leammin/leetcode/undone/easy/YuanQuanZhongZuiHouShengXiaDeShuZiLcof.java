package com.leammin.leetcode.undone.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 
 * <p>0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。</p>
 * 
 * <p>例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入:</strong> n = 5, m = 3
 * <strong>输出:&nbsp;</strong>3
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入:</strong> n = 10, m = 17
 * <strong>输出:&nbsp;</strong>2
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n&nbsp;&lt;= 10^5</code></li>
 * 	<li><code>1 &lt;= m &lt;= 10^6</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-30
 */
public interface YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    int lastRemaining(int n, int m);

    class Solution implements YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

        @Override
        public int lastRemaining(int n, int m) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int start = 0;
            while (list.size() != 1) {
                start = (start + m - 1) % list.size();
                list.remove(start);
            }
            return list.get(0);
        }
    }

    class Best implements YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

        @Override
        public int lastRemaining(int n, int m) {
            int f = 0;
            for (int i = 2; i != n + 1; ++i)
                f = (m + f) % i;
            return f;
        }
    }
}
