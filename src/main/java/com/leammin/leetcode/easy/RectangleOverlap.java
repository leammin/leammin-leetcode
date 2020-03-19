package com.leammin.leetcode.easy;

/**
 * 836. 矩形重叠
 *
 * <p>矩形以列表 <code>[x1, y1, x2, y2]</code> 的形式表示，其中 <code>(x1, y1)</code> 为左下角的坐标，<code>(x2, y2)</code> 是右上角的坐标。</p>
 *
 * <p>如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。</p>
 *
 * <p>给出两个矩形，判断它们是否重叠并返回结果。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ol>
 * 	<li>两个矩形 <code>rec1</code> 和 <code>rec2</code> 都以含有四个整数的列表的形式给出。</li>
 * 	<li>矩形中的所有坐标都处于 <code>-10^9</code> 和 <code>10^9</code> 之间。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-03-18
 */
public interface RectangleOverlap {
    boolean isRectangleOverlap(int[] rec1, int[] rec2);

    class Solution implements RectangleOverlap {

        @Override
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return overlap(rec1, rec2) || overlap(rec2, rec1);
        }

        private boolean overlap(int[] rec1, int[] rec2) {
            return (((rec1[0] >= rec2[0] && rec1[0] < rec2[2]) || (rec1[2] > rec2[0] && rec1[2] <= rec2[2]))
                    && ((rec1[1] >= rec2[1] && rec1[1] < rec2[3]) || (rec1[3] <= rec2[3] && rec1[3] > rec2[1])))
                    || (rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] >= rec2[1] && rec1[1] < rec2[3]);
        }
    }

    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 xx 轴平行的边（水平边）投影到 xx 轴上时会有交集，与 yy 轴平行的边（竖直边）投影到 yy 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题。
     */
    class Best implements RectangleOverlap {

        @Override
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                    Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
        }
    }
}
