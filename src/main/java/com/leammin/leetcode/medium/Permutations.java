package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 46. 全排列
 *
 * <p>给定一个<strong>没有重复</strong>数字的序列，返回其所有可能的全排列。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3]
 * <strong>输出:</strong>
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]</pre>
 *
 * @author Leammin
 * @date 2020-03-22
 */
public interface Permutations {
    List<List<Integer>> permute(int[] nums);

    static Testsuite<Permutations> testsuite() {
        return Testsuite.<Permutations>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.permute(new int[]{1, 2, 3}), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 3),
                        List.of(2, 3, 1),
                        List.of(3, 1, 2),
                        List.of(3, 2, 1)
                )))
                .build();
    }


    class Solution implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> ans = new ArrayList<>(factorial(nums.length));
            List<Integer> p = new ArrayList<>(nums.length);
            ans.add(p);
            permute(ans, p, nums);
            return ans;
        }

        private void permute(List<List<Integer>> ans, List<Integer> p, int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                ArrayList<Integer> cloned = clone(nums.length, p);
                cloned.add(nums[i]);
                ans.add(cloned);
                permute(ans, cloned, remove(nums, i));
            }
            p.add(nums[0]);
            if (nums.length > 1) {
                permute(ans, p, remove(nums, 0));
            }
        }

        private static int[] remove(int[] nums, int index) {
            int[] res = new int[nums.length - 1];
            System.arraycopy(nums, 0, res, 0, index);
            System.arraycopy(nums, index + 1, res, index, nums.length - index - 1);
            return res;
        }

        private ArrayList<Integer> clone(int n, List<Integer> p) {
            ArrayList<Integer> res = new ArrayList<>(n);
            res.addAll(p);
            return res;
        }

        private int factorial(int n) {
            int res = 1;
            while (n > 1) {
                res *= n;
                n--;
            }
            return res;
        }
    }

    class Best implements Permutations {
        public void backtrack(int n,
                              ArrayList<Integer> nums,
                              List<List<Integer>> output,
                              int first) {
            // if all integers are used up
            if (first == n)
                output.add(new ArrayList<>(nums));
            for (int i = first; i < n; i++) {
                // place i-th integer first
                // in the current permutation
                Collections.swap(nums, first, i);
                // use next integers to complete the permutations
                backtrack(n, nums, output, first + 1);
                // backtrack
                Collections.swap(nums, first, i);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            // init output list
            List<List<Integer>> output = new ArrayList<>(factorial(nums.length));

            // convert nums into list since the output is a list of lists
            ArrayList<Integer> nums_lst = new ArrayList<>(nums.length);
            for (int num : nums)
                nums_lst.add(num);

            int n = nums.length;
            backtrack(n, nums_lst, output, 0);
            return output;
        }

        private int factorial(int n) {
            int res = 1;
            while (n > 1) {
                res *= n;
                n--;
            }
            return res;
        }
    }
}

class PermutationsTest extends AbstractTest<Permutations> {
}
