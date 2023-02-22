package com.leammin.leetcode.medium;

/**
 * 1140. 石子游戏 II
 *
 * <p>亚历克斯和李继续他们的石子游戏。许多堆石子&nbsp;<strong>排成一行</strong>，每堆都有正整数颗石子&nbsp;<code>piles[i]</code>。游戏以谁手中的石子最多来决出胜负。</p>
 *
 * <p>亚历克斯和李轮流进行，亚历克斯先开始。最初，<code>M = 1</code>。</p>
 *
 * <p>在每个玩家的回合中，该玩家可以拿走剩下的&nbsp;<strong>前</strong>&nbsp;<code>X</code>&nbsp;堆的所有石子，其中&nbsp;<code>1 &lt;= X &lt;= 2M</code>。然后，令&nbsp;<code>M = max(M, X)</code>。</p>
 *
 * <p>游戏一直持续到所有石子都被拿走。</p>
 *
 * <p>假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>piles = [2,7,9,4,4]
 * <strong>输出：</strong>10
 * <strong>解释：
 * </strong>如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= piles.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= piles[i]&nbsp;&lt;= 10 ^ 4</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-22
 */
public interface StoneGameIi {
    int stoneGameII(int[] piles);

    class Solution implements StoneGameIi {

        @Override
        public int stoneGameII(int[] piles) {
            int[] sum = new int[piles.length];
            sum[piles.length - 1] = piles[piles.length - 1];
            for (int i = piles.length - 2; i >= 0; i--) {
                sum[i] = sum[i + 1] + piles[i];
            }
            return maxStones(0, 1, piles, sum, new int[piles.length][piles.length / 2 + 1]);
        }

        private int maxStones(int start, int m, int[] piles, int[] sum, int[][] dp) {
            if (2 * m + start >= piles.length) {
                return sum[start];
            }
            if (dp[start][m] != 0) {
                return dp[start][m];
            }
            for (int x = 1; x <= 2 * m; x++) {
                int bob = maxStones(x + start, Math.max(m, x), piles, sum, dp);
                dp[start][m] = Math.max(dp[start][m], sum[start] - bob);
            }
            return dp[start][m];
        }
    }
}
