package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 08.11. 硬币
 * 
 * <p>硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)</p>
 * 
 * <p> <strong>示例1:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>: n = 5
 * <strong> 输出</strong>：2
 * <strong> 解释</strong>: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * </pre>
 * 
 * <p> <strong>示例2:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>: n = 10
 * <strong> 输出</strong>：4
 * <strong> 解释</strong>: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * </pre>
 * 
 * <p> <strong>说明：</strong></p>
 * 
 * <p>注意:</p>
 * 
 * <p>你可以假设：</p>
 * 
 * <ul>
 * <li>0 &lt;= n (总金额) &lt;= 1000000</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-04-23
 */
public interface CoinLcci {
    int waysToChange(int n);

    static Testsuite<CoinLcci> testsuite() {
        return Testsuite.<CoinLcci>builder()
                .add(ExpectedTestcase.of(t -> t.waysToChange(5), 2))
                .add(ExpectedTestcase.of(t -> t.waysToChange(10), 4))
                .add(ExpectedTestcase.of(t -> t.waysToChange(20), 9))
                .add(ExpectedTestcase.of(t -> t.waysToChange(61), 73))
                .add(ExpectedTestcase.of(t -> t.waysToChange(15), 6))
                .add(ExpectedTestcase.of(t -> t.waysToChange(4), 1))
                .add(ExpectedTestcase.of(t -> t.waysToChange(9), 2))
                .add(ExpectedTestcase.of(t -> t.waysToChange(14), 4))
                .add(ExpectedTestcase.of(t -> t.waysToChange(19), 6))
                .add(ExpectedTestcase.of(t -> t.waysToChange(24), 9))
                .add(ExpectedTestcase.of(t -> t.waysToChange(29), 13))
                .add(ExpectedTestcase.of(t -> t.waysToChange(34), 18))
                .add(ExpectedTestcase.of(t -> t.waysToChange(39), 24))
                .add(ExpectedTestcase.of(t -> t.waysToChange(900750), 504188296))
                .build();
    }


    class Solution implements CoinLcci {
        int[] cache;

        @Override
        public int waysToChange(int n) {
            cache = new int[n];
            if (n == 0) {
                return 0;
            }
            return waysToChange(n, new int[]{25, 10, 5, 1}, 0);
        }

        private int waysToChange(int n, int[] coins, int ci) {
            if (n == 0 || ci == 3) {
                return 1;
            }
            if (ci == 2) {
                return n / 5 + 1;
            }
            if (ci == 1) {
                long t = (long) (n / 5 - n / 10 + 1) * (long) (n / 10 + 1);
                return (int) (t % 1000000007);
            }
            if (cache[n - 1] != 0) {
                return cache[n - 1];
            }
            int ans = 0;
            for (int i = 0; i * coins[ci] <= n; i++) {
                ans += waysToChange(n - i * coins[ci], coins, ci + 1);
                ans %= 1000000007;
            }
            cache[n - 1] = ans;
            return ans;
        }
    }

    class Solution2 implements CoinLcci {

        @Override
        public int waysToChange(int n) {
            int ans = 0;
            for (int i = 0; i <= n / 25; i++) {
                ans += coins(n - i * 25);
                ans %= 1000000007;
            }
            return ans;
        }

        private int coins(int n) {
            long t = (long) (n / 5 - n / 10 + 1) * (long) (n / 10 + 1);
            return (int) (t % 1000000007);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 300; i++) {
            System.out.println(i + "\t: " + new Solution().waysToChange(i));
        }
    }
}

class CoinLcciTest extends AbstractTest<CoinLcci> {
}
