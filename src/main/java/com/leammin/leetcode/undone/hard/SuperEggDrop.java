package com.leammin.leetcode.undone.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 *
 * <p>你将获得&nbsp;<code>K</code>&nbsp;个鸡蛋，并可以使用一栋从&nbsp;<code>1</code>&nbsp;到&nbsp;<code>N</code>&nbsp;&nbsp;共有 <code>N</code>&nbsp;层楼的建筑。</p>
 *
 * <p>每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。</p>
 *
 * <p>你知道存在楼层&nbsp;<code>F</code> ，满足&nbsp;<code>0 &lt;= F &lt;= N</code> 任何从高于 <code>F</code>&nbsp;的楼层落下的鸡蛋都会碎，从&nbsp;<code>F</code>&nbsp;楼层或比它低的楼层落下的鸡蛋都不会破。</p>
 *
 * <p>每次<em>移动</em>，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层&nbsp;<code>X</code>&nbsp;扔下（满足&nbsp;<code>1 &lt;= X &lt;= N</code>）。</p>
 *
 * <p>你的目标是<strong>确切地</strong>知道 <code>F</code> 的值是多少。</p>
 *
 * <p>无论 <code>F</code> 的初始值如何，你确定 <code>F</code> 的值的最小移动次数是多少？</p>
 *
 * <p>&nbsp;</p>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>K = 1, N = 2
 * <strong>输出：</strong>2
 * <strong>解释：</strong>
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>K = 2, N = 6
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>K = 3, N = 14
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= K &lt;= 100</code></li>
 * 	<li><code>1 &lt;= N &lt;= 10000</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-04-11
 */
public interface SuperEggDrop {
    int superEggDrop(int K, int N);

    class Solution implements SuperEggDrop {

        @Override
        public int superEggDrop(int K, int N) {
            int[][] dp = new int[K][N];
            for (int ni = 1; ni <= N; ni++) {
                dp[0][ni - 1] = ni;
            }
            for (int ki = 1; ki <= K; ki++) {
                dp[ki - 1][0] = 1;
                dp[ki - 1][1] = 2;
            }
            for (int ki = 2; ki <= K; ki++) {
                for (int ni = 3; ni <= N; ni++) {
                    int d = ni;
                    for (int i = 2; i <= ni / 2 + 1; i++) {
                        int s = Math.max(dp[ki - 1][ni - 1 - i], dp[ki - 1 - 1][i - 1 - 1]) + 1;
                        d = Math.min(d, s);
                    }
                    dp[ki - 1][ni - 1] = d;
                }
            }
//            System.out.println(Arrays.deepToString(dp));
            return dp[K - 1][N - 1];
        }
    }

//    class Solution2 implements SuperEggDrop {
//
//        @Override
//        public int superEggDrop(int K, int N) {
//            if (K == 1 || N == 1 || N == 2) {
//                return N;
//            }
//            int[][] dp = new int[K][N];
//            for (int ni = 1; ni <= N; ni++) {
//                dp[0][ni - 1] = ni;
//            }
//            for (int ki = 1; ki <= K; ki++) {
//                dp[ki - 1][0] = 1;
//                dp[ki - 1][1] = 2;
//            }
//            for (int ki = 2; ki <= K; ki++) {
//                int di = ki - 1;
//                int dj = 0;
//                for (int ni = 3; ni <= N/2 + 1; ni++) {
//                    dp[ki - 1][ni - 1] = dp[di][dj] + 1;
//                    if ((ni & 1) == 1) {
//                        di--;
//                        dj++;
//                    } else {
//                        di++;
//                    }
//                }
//            }
//            System.out.println(Arrays.deepToString(dp));
//            return dp[K - 1][N - 1];
//        }
//    }

    class Demo implements SuperEggDrop {
        public int superEggDrop(int K, int N) {
            return dp(K, N);
        }

        Map<Integer, Integer> memo = new HashMap();

        public int dp(int K, int N) {
            if (!memo.containsKey(N * 100 + K)) {
                int ans;
                if (N == 0)
                    ans = 0;
                else if (K == 1)
                    ans = N;
                else {
                    int lo = 1, hi = N;
                    while (lo + 1 < hi) {
                        int x = (lo + hi) / 2;
                        int t1 = dp(K - 1, x - 1);
                        int t2 = dp(K, N - x);

                        if (t1 < t2)
                            lo = x;
                        else if (t1 > t2)
                            hi = x;
                        else
                            lo = hi = x;
                    }

                    ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
                            Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
                }

                memo.put(N * 100 + K, ans);
            }

            return memo.get(N * 100 + K);
        }
    }
}
