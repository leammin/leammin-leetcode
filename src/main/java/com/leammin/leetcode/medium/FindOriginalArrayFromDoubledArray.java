package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-original-array-from-doubled-array/">2007. 从双倍数组中还原原数组</a>
 *
 * <p>一个整数数组&nbsp;<code>original</code>&nbsp;可以转变成一个 <strong>双倍</strong>&nbsp;数组&nbsp;<code>changed</code>&nbsp;，转变方式为将 <code>original</code>&nbsp;中每个元素 <strong>值乘以 2 </strong>加入数组中，然后将所有元素 <strong>随机打乱</strong>&nbsp;。</p>
 *
 * <p>给你一个数组&nbsp;<code>changed</code>&nbsp;，如果&nbsp;<code>change</code>&nbsp;是&nbsp;<strong>双倍</strong>&nbsp;数组，那么请你返回&nbsp;<code>original</code>数组，否则请返回空数组。<code>original</code>&nbsp;的元素可以以&nbsp;<strong>任意</strong>&nbsp;顺序返回。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><b>输入：</b>changed = [1,3,4,2,6,8]
 * <b>输出：</b>[1,3,4]
 * <b>解释：</b>一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>changed = [6,3,0,1]
 * <b>输出：</b>[]
 * <b>解释：</b>changed 不是一个双倍数组。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><b>输入：</b>changed = [1]
 * <b>输出：</b>[]
 * <b>解释：</b>changed 不是一个双倍数组。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= changed.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= changed[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2024-04-18
 */
public interface FindOriginalArrayFromDoubledArray {
    int[] findOriginalArray(int[] changed);

    static Testsuite<FindOriginalArrayFromDoubledArray> testsuite() {
        return Testsuite.<FindOriginalArrayFromDoubledArray>builder()
                .addExpected(t -> t.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}), new int[]{1, 3, 4})
                .addExpected(t -> t.findOriginalArray(new int[]{6,3,0,1}), new int[]{})
                .addExpected(t -> t.findOriginalArray(new int[]{1}), new int[]{})
                .build();
    }

    class Solution implements FindOriginalArrayFromDoubledArray {

        @Override
        public int[] findOriginalArray(int[] changed) {
            if (changed.length == 0) {
                return new int[0];
            }
            if (changed.length % 2 != 0) {
                return new int[0];
            }
            Arrays.sort(changed);
            int[] res = new int[changed.length / 2];
            int a = 0, b = 0;
            for (int c : changed) {
                if (a == b || res[a] * 2 != c) {
                    if (b >= res.length) {
                        return new int[0];
                    }
                    res[b] = c;
                    b++;
                } else {
                    a++;
                }
            }
            return res;
        }
    }
}