package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 16.03. 交点
 * 
 * <p>给定两条线段（表示为起点<code>start = {X1, Y1}</code>和终点<code>end = {X2, Y2}</code>），如果它们有交点，请计算其交点，没有交点则返回空值。</p>
 * </p>要求浮点型误差不超过<code>10^-6</code>。若有多个交点（线段重叠）则返回X值最小的点，X坐标相同则返回Y值最小的点。</p>
 * <p><strong>示例 1：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * <strong>输出：</strong> {0.5, 0}
 * </pre>
 * <p><strong>示例 2：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * <strong>输出：</strong> {1, 1}
 * </pre>
 * <p><strong>示例 3：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * <strong>输出：</strong> {}，两条线段没有交点
 * </pre>
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>坐标绝对值不会超过2^7</li>
 * <li>输入的坐标均是有效的二维坐标</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-04-13
 */
public interface IntersectionLcci {
    double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2);

    static Testsuite<IntersectionLcci> testsuite() {
        return Testsuite.<IntersectionLcci>builder()
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1}), new double[]{0.5, 0}))
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{3, 3}, new int[]{1, 1}, new int[]{2, 2}), new double[]{1, 1}))
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 1}), new double[]{}))
                .build();
    }


    class Solution implements IntersectionLcci {

        @Override
        public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            if (start1[0] == end1[0] && start2[0] == end2[0]) {
                if (start1[0] != start2[0]) {
                    return new double[0];
                }
                if (Math.max(start1[1], end1[1]) < Math.min(start2[1], end2[1])
                        || Math.max(start2[1], end2[1]) < Math.min(start1[1], end1[1])) {
                    return new double[0];
                }
                return new double[]{start1[0], min2(start1[1], end1[1], start2[1], end2[1])};
            }
            if (start1[0] == end1[0]) {
                int[] tmp = start1;
                start1 = start2;
                start2 = tmp;
                tmp = end1;
                end1 = end2;
                end2 = tmp;
            }
            if (start2[0] == end2[0]) {
                double a1 = (start1[1] - end1[1]) / (double) (start1[0] - end1[0]);
                double b1 = start1[1] - a1 * start1[0];

                double x = start2[0];
                double y = a1 * x + b1;

                if (between(x, start1[0], end1[0]) && between(x, start2[0], end2[0]) && between(y, start1[1], end1[1]) && between(y, start2[1], end2[1])) {
                    return new double[]{x, y};
                }

                return new double[0];
            }

            double a1 = (start1[1] - end1[1]) / (double) (start1[0] - end1[0]);
            double b1 = start1[1] - a1 * start1[0];

            double a2 = (start2[1] - end2[1]) / (double) (start2[0] - end2[0]);
            double b2 = start2[1] - a2 * start2[0];

            if (a1 == a2) {
                if (b1 != b2) {
                    return new double[0];
                }
                if (Math.max(start1[0], end1[0]) < Math.min(start2[0], end2[0])
                        || Math.max(start2[0], end2[0]) < Math.min(start1[0], end1[0])) {
                    return new double[0];
                }
                int[] res = minX2(start1, end1, start2, end2);
                return new double[]{res[0], res[1]};
            }
            double x = (b2 - b1) / (a1 - a2);
            double y = a1 * x + b1;
            if (between(x, start1[0], end1[0]) && between(x, start2[0], end2[0]) && between(y, start1[1], end1[1]) && between(y, start2[1], end2[1])) {
                return new double[]{x, y};
            }

            return new double[0];
        }

        private boolean between(double target, double a, double b) {
            return target >= a && target <= b || target >= b && target <= a;
        }

        private int[] minX2(int[]... ds) {
            int[] t1 = ds[0];
            int[] t2 = ds[1];
            for (int i = 2; i < ds.length; i++) {
                if (ds[i][0] < t1[0]) {
                    t2 = t1;
                    t1 = ds[i];
                } else if (ds[i][0] < t2[0]) {
                    t2 = ds[i];
                }
            }
            return t2;
        }

        private double min2(double... ds) {
            double t1 = ds[0];
            double t2 = ds[1];
            for (int i = 2; i < ds.length; i++) {
                if (ds[i] < t1) {
                    t2 = t1;
                    t1 = ds[i];
                } else if (ds[i] < t2) {
                    t2 = ds[i];
                }
            }
            return t2;
        }
    }
}

class IntersectionLcciTest extends AbstractTest<IntersectionLcci> {
}
