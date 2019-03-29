package com.leammin.leetcode.medium;


import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 120. 三角形最小路径和
 *
 * <div><p>给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。</p>
 *
 * <p>例如，给定三角形：</p>
 *
 * <pre>[
 *      [<strong>2</strong>],
 *     [<strong>3</strong>,4],
 *    [6,<strong>5</strong>,7],
 *   [4,<strong>1</strong>,8,3]
 * ]
 * </pre>
 *
 * <p>自顶向下的最小路径和为&nbsp;<code>11</code>（即，<strong>2&nbsp;</strong>+&nbsp;<strong>3</strong>&nbsp;+&nbsp;<strong>5&nbsp;</strong>+&nbsp;<strong>1</strong>&nbsp;= 11）。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>如果你可以只使用 <em>O</em>(<em>n</em>)&nbsp;的额外空间（<em>n</em> 为三角形的总行数）来解决这个问题，那么你的算法会很加分。</p>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-29
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        Integer[] cache = triangle.get(triangle.size() - 1).toArray(new Integer[triangle.size()]);
        ListIterator<List<Integer>> iterator = triangle.listIterator(triangle.size() - 1);
        while (iterator.hasPrevious()) {
            List<Integer> row = iterator.previous();
            for (int i = 0; i < row.size(); i++) {
                cache[i] = row.get(i) + Math.min(cache[i], cache[i + 1]);
            }
        }
        return cache[0];
    }
}
