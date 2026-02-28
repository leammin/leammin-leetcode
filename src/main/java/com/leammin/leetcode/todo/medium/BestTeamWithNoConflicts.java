package com.leammin.leetcode.todo.medium;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/best-team-with-no-conflicts/">1626. 无矛盾的最佳球队</a>
 *
 * <p>假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 <strong>总和</strong> 。</p>
 *
 * <p>然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 <strong>没有矛盾</strong> 的球队。如果一名年龄较小球员的分数 <strong>严格大于</strong> 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。</p>
 *
 * <p>给你两个列表 <code>scores</code> 和 <code>ages</code>，其中每组 <code>scores[i]</code> 和 <code>ages[i]</code> 表示第 <code>i</code> 名球员的分数和年龄。请你返回 <strong>所有可能的无矛盾球队中得分最高那支的分数</strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * <strong>输出：</strong>34
 * <strong>解释：</strong>你可以选中所有球员。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>scores = [4,5,6,5], ages = [2,1,2,1]
 * <strong>输出：</strong>16
 * <strong>解释：</strong>最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>scores = [1,2,3,5], ages = [8,9,10,1]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>最佳的选择是前 3 名球员。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= scores.length, ages.length &lt;= 1000</code></li>
 * 	<li><code>scores.length == ages.length</code></li>
 * 	<li><code>1 &lt;= scores[i] &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>1 &lt;= ages[i] &lt;= 1000</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-22
 */
public interface BestTeamWithNoConflicts {
    int bestTeamScore(int[] scores, int[] ages);

    static Testsuite<BestTeamWithNoConflicts> testsuite() {
        return Testsuite.<BestTeamWithNoConflicts>builder()
                .addExpected(t -> t.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}), 34)
                .addExpected(t -> t.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}), 16)
                .addExpected(t -> t.bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}), 6)
                .addExpected(t -> t.bestTeamScore(new int[]{319776, 611683, 835240, 602298, 430007, 574, 142444, 858606, 734364, 896074}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}), 5431066)
                .addExpected(t -> t.bestTeamScore(new int[]{6, 5, 1, 7, 6, 5, 5, 4, 10, 4}, new int[]{3, 2, 5, 3, 2, 1, 4, 4, 5, 1}), 43)
                .addExpected(t -> t.bestTeamScore(new int[]{1,1,1,1,1,1,1,1,1,1}, new int[]{811,364,124,873,790,656,581,446,885,134}), 10)
                .build();
    }

    class Solution implements BestTeamWithNoConflicts {
        @Override
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[][] men = new int[n][2]; // [age, score]
            for (int i = 0; i < n; i++) {
                men[i] = new int[]{ages[i], scores[i]};
            }
            Arrays.sort(men, Comparator.<int[]>comparingInt(m -> m[0]).thenComparingInt(m -> m[1])); // nlogn

            List<Integer> groupStartIndex = new ArrayList<>();
            groupStartIndex.add(n);

            int[] dp = new int[n];
            int res = dp[n - 1] = men[n - 1][1];
            for (int i = n - 2; i >= 0; i--) { // nmlogn
                if (men[i][0] == men[n - 1][0] || men[i][0] == men[i + 1][0] && men[i][1] == men[i + 1][1]) {
                    dp[i] = men[i][1] + dp[i + 1];
                    res = Math.max(res, dp[i]);
                    continue;
                }
                dp[i] = dp[i + 1];
                if (men[i][0] != men[i + 1][0]) {
                    groupStartIndex.add(i + 1);
                    dp[i] = 0;
                }
                for (int g = groupStartIndex.size() - 1; g > 0; g--) {
                    int x = binarySearch(men, groupStartIndex.get(g), groupStartIndex.get(g - 1), men[i][1]);
                    if (x < groupStartIndex.get(g - 1)) {
                        if (dp[i] < dp[x]) {
                            dp[i] = dp[x];
                        }
                        if (men[x][1] == men[i][1]) {
                            break;
                        }
                    }
                }
                dp[i] += men[i][1];
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        private int binarySearch(int[][] men, int from, int to, int target) {
            int l = from;
            int r = to;
            while (l < r) {
                int mid = (l + r) / 2;
                if (men[mid][1] > target) {
                    r = mid;
                } else if (men[mid][1] == target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

    }

    class Solution2 implements BestTeamWithNoConflicts {

        @Override
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[] men = new int[n];
            for (int i = 0; i < n; i++) {
                men[i] = scores[i] * 1000 + ages[i] - 1;
            }
            Arrays.sort(men);

            return 0;
        }
    }
}

class BestTeamWithNoConflictsTest extends AbstractTest<BestTeamWithNoConflicts> {
}
