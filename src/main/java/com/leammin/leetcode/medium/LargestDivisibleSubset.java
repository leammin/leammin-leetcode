package com.leammin.leetcode.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.List;
import java.util.Set;

/**
 * 368. 最大整除子集
 *
 * <p>给出一个由<strong>无重复的</strong>正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (S<sub>i，</sub>S<sub>j</sub>) 都要满足：S<sub>i</sub> % S<sub>j</sub> = 0 或 S<sub>j</sub> % S<sub>i</sub> = 0。</p>
 *
 * <p>如果有多个目标子集，返回其中任何一个均可。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3]
 * <strong>输出:</strong> [1,2] (当然, [1,3] 也正确)
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,4,8]
 * <strong>输出:</strong> [1,2,4,8]
 * </pre>
 *
 * @author Leammin
 * @date 2021-04-23
 */
public interface LargestDivisibleSubset {
    List<Integer> largestDivisibleSubset(int[] nums);

    static Testsuite<LargestDivisibleSubset> testsuite() {
        return Testsuite.<LargestDivisibleSubset>builder()
                .addAnyExpected(t -> Set.copyOf(t.largestDivisibleSubset(new int[]{1,2,3})), List.of(Set.of(1, 2), Set.of(1,3)))
                .addAnyExpected(t -> Set.copyOf(t.largestDivisibleSubset(new int[]{2,3,4,9,8})), List.of(Set.of(2,4,8)))
                .build();
    }


    class Solution implements LargestDivisibleSubset {

        @Override
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            List<Integer>[] dp = new List[nums.length];
            List<Integer> max = Collections.emptyList();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> l = Collections.emptyList();
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0 && dp[j].size() > l.size()) {
                        l = dp[j];/**/
                        if (l.size() >= max.size()) {
                            break;
                        }
                    }
                }
                dp[i] = new ArrayList<>(l.size() + 1);
                dp[i].addAll(l);
                dp[i].add(nums[i]);
                if (dp[i].size() > max.size()) {
                    max = dp[i];
                }
            }
            return max;
        }
    }

    class Solution2 implements LargestDivisibleSubset {

        @Override
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            Node[] dp = new Node[nums.length];
            Node max = null;
            for (int i = 0; i < nums.length; i++) {
                Node n = null;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0 && (n == null ||  dp[j].size > n.size)) {
                        n = dp[j];
                        if (n.size >= max.size) {
                            break;
                        }
                    }
                }
                dp[i] = new Node();
                dp[i].next = n;
                dp[i].value = nums[i];
                dp[i].size = n == null ? 1 : (n.size + 1);
                if (max == null || dp[i].size > max.size) {
                    max = dp[i];
                }
            }
            List<Integer> res = new ArrayList<>(max.size);
            while (max != null) {
                res.add(max.value);
                max = max.next;
            }
            return res;
        }

        static class Node {
            int value;
            int size;
            Node next;
        }
    }
}

class LargestDivisibleSubsetTest extends AbstractTest<LargestDivisibleSubset> {
}
