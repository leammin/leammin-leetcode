package com.leammin.leetcode.easy;

import java.util.TreeSet;

/**
 * 204. 计数质数
 *
 * <div><p>统计所有小于非负整数&nbsp;<em>n&nbsp;</em>的质数的数量。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 10
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-09
 */
public interface CountPrimes {
    int countPrimes(int n);

    class Solution implements CountPrimes {
        @Override
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }

            boolean[] nums = new boolean[n];
            for (int i = 2; i < n; i++) {
                nums[i] = true;
            }

            for (int i = 2; i < n; i++) {
                if (nums[i]) {
                    int target = i + i;
                    while (target < n) {
                        nums[target] = false;
                        target += i;
                    }
                }
            }

            int result = 0;

            for (boolean isPrime : nums) {
                if (isPrime) {
                    result++;
                }
            }
            return result;
        }
    }

    class Solution1 implements CountPrimes {
        @Override
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }

            TreeSet<Integer> primes = new TreeSet<>();
            primes.add(2);

            for (int i = 3; i < n; i++) {
                int head = (int) Math.ceil(Math.sqrt(i));
                boolean isPrime = true;
                for (Integer prime : primes.headSet(head, true)) {
                    if (i % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(i);
                }
            }

            return primes.size();
        }
    }
}
