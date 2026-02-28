package com.leammin.leetcode.todo.hard;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/">982. 按位与为零的三元组</a>
 * 
 * <p>给你一个整数数组 <code>nums</code> ，返回其中 <strong>按位与三元组</strong> 的数目。</p>
 * 
 * <p><strong>按位与三元组</strong> 是由下标 <code>(i, j, k)</code> 组成的三元组，并满足下述全部条件：</p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= i &lt; nums.length</code></li>
 * 	<li><code>0 &lt;= j &lt; nums.length</code></li>
 * 	<li><code>0 &lt;= k &lt; nums.length</code></li>
 * 	<li><code>nums[i] &amp; nums[j] &amp; nums[k] == 0</code> ，其中 <code>&amp;</code> 表示按位与运算符。</li>
 * </ul>
 * &nbsp;
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [2,1,3]
 * <strong>输出：</strong>12
 * <strong>解释：</strong>可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 &amp; 2 &amp; 1
 * (i=0, j=1, k=0) : 2 &amp; 1 &amp; 2
 * (i=0, j=1, k=1) : 2 &amp; 1 &amp; 1
 * (i=0, j=1, k=2) : 2 &amp; 1 &amp; 3
 * (i=0, j=2, k=1) : 2 &amp; 3 &amp; 1
 * (i=1, j=0, k=0) : 1 &amp; 2 &amp; 2
 * (i=1, j=0, k=1) : 1 &amp; 2 &amp; 1
 * (i=1, j=0, k=2) : 1 &amp; 2 &amp; 3
 * (i=1, j=1, k=0) : 1 &amp; 1 &amp; 2
 * (i=1, j=2, k=0) : 1 &amp; 3 &amp; 2
 * (i=2, j=0, k=1) : 3 &amp; 2 &amp; 1
 * (i=2, j=1, k=0) : 3 &amp; 1 &amp; 2
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [0,0,0]
 * <strong>输出：</strong>27
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt; 2<sup>16</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-04
 */
public interface TriplesWithBitwiseAndEqualToZero {
    int countTriplets(int[] nums);

    static Testsuite<TriplesWithBitwiseAndEqualToZero> testsuite() {
        return Testsuite.<TriplesWithBitwiseAndEqualToZero>builder()
                .addExpected(t -> t.countTriplets(new int[]{2,1,3}), 12)
                .addExpected(t -> t.countTriplets(new int[]{0,0,0}), 27)
                .addExpected(t -> t.countTriplets(new int[]{0,1}), 7)
                .addExpected(t -> t.countTriplets(new int[]{2,4,7,3}), 30)
                .build();
    }

    class Solution implements TriplesWithBitwiseAndEqualToZero {

        @Override
        public int countTriplets(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    for (int k = 0; k < nums.length; k++) {
                        if ((nums[i] & nums[j] & nums[k]) == 0) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }


    class Solution2 implements TriplesWithBitwiseAndEqualToZero {

        @Override
        public int countTriplets(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    res += n * n;
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if ((nums[i] & nums[j]) == 0) {
                        res += n;
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if ((nums[i] & nums[j] & nums[k]) == 0) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }


    @Execute(false)
    class Solution3 implements TriplesWithBitwiseAndEqualToZero {

        @Override
        public int countTriplets(int[] nums) {
            List<Integer>[] group = new List[33];
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int fo = firstOne(nums[i]);
                if (group[fo] == null) {
                    group[fo] = new ArrayList<>();
                }
                group[fo].add(nums[i]);
            }
            int zero = group[0] == null ? 0 : group[0].size();
            int res = n * n * n - (n - zero) * (n - zero) * (n - zero);
            for (int i = 1; i < group.length - 1; i++) {
                if (group[i] == null || group[i].size() == 0) {
                    continue;
                }
                for (int gin : group[i]) {
                    for (int j = i + 1; j < group.length; j++) {
                        if (group[j] == null || group[j].size() == 0) {
                            continue;
                        }
                        for (int gjn : group[j]) {
                            int x = gin & gjn;
                            if (x == 0) {
                                res += 6 * (n - zero - 2) + 3 + 3;
                                continue;
                            }
                            for (int k = i; k < group.length; k++) {
                                if (group[k] == null || group[k].size() == 0 || (x & (1 << (k - 1))) != 0) {
                                    continue;
                                }
                                for (int gkn : group[k]) {
                                    if ((x & gkn) == 0 && ((gkn & gin) != 0) && ((gkn & gjn) != 0)) {
                                        res += 3;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }

        private int firstOne(int a) {
            if (a == 0) {
                return 0;
            }
            int res = 1;
            int t = 1;
            while ((a & t) == 0) {
                t = (t << 1) + 1;
                res++;
            }
            return res;
        }

        public static void main(String[] args) {
            Assertions.assertThat(new Solution3().firstOne(0b100)).isEqualTo(3);
            Assertions.assertThat(new Solution3().firstOne(0b110)).isEqualTo(2);
            Assertions.assertThat(new Solution3().firstOne(0b111)).isEqualTo(1);
            Assertions.assertThat(new Solution3().firstOne(0)).isEqualTo(0);
            Assertions.assertThat(new Solution3().firstOne(1 << 31)).isEqualTo(32);
        }

    }



    class Solution4 implements TriplesWithBitwiseAndEqualToZero {

        @Override
        public int countTriplets(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    res += n * n;
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    int x = nums[i] & nums[j];
                    if (x == 0) {
                        res += n;
                        continue;
                    }

                }
            }
            return res;
        }

    }
}

class TriplesWithBitwiseAndEqualToZeroTest extends AbstractTest<TriplesWithBitwiseAndEqualToZero> {
}
