package com.leammin.leetcode.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.List;

/**
 * 18. 四数之和
 *
 * <p>给定一个包含&nbsp;<em>n</em> 个整数的数组&nbsp;<code>nums</code>&nbsp;和一个目标值&nbsp;<code>target</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在四个元素 <em>a，</em><em>b，c</em>&nbsp;和 <em>d</em>&nbsp;，使得&nbsp;<em>a</em> + <em>b</em> + <em>c</em> + <em>d</em>&nbsp;的值与&nbsp;<code>target</code>&nbsp;相等？找出所有满足条件且不重复的四元组。</p>
 *
 * <p><strong>注意：</strong></p>
 *
 * <p>答案中不可以包含重复的四元组。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2021-04-01
 */
public interface FourSum {
    List<List<Integer>> fourSum(int[] nums, int target);

    static Testsuite<FourSum> testsuite() {
        return Testsuite.<FourSum>builder()
                .addExpected(t -> t.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), List.of(
                        List.of(-2, -1, 1, 2),
                        List.of(-2,  0, 0, 2),
                        List.of(-1,  0, 0, 1)
                ))
                .addExpected(t -> t.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0), List.of(
                        List.of(-2,-1,1,2),
                        List.of(-1,-1,1,1)
                ))
                .build();
    }


    class Solution implements FourSum {

        @Override
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Map<Integer, Integer> lastIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                lastIndex.put(nums[i], i);
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    for (int k = j + 1; k < nums.length; k++) {
                        if (k > j + 1 && nums[k] == nums[k - 1]) {
                            continue;
                        }
                        int abc = nums[i] + nums[j] + nums[k];
                        int d = target - abc;
                        if (d < nums[k]) {
                            break;
                        }
                        Integer last = lastIndex.get(d);
                        if (last != null && last > k) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], d));
                        }
                    }
                }
            }
            return res;
        }
    }

    class Solution2 implements FourSum {

        @Override
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i <= n - 4; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j <= n - 3; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                        continue;
                    }
                    int ab = nums[i] + nums[j];
                    int cd = target - ab;
                    int l = j + 1, r = n - 1;
                    while (l < r) {
                        if (l > j + 1 && nums[l] == nums[l - 1]) {
                            l++;
                            continue;
                        }
                        if (r < n - 1 && nums[r] == nums[r + 1]) {
                            r--;
                            continue;
                        }
                        int lr = nums[l] + nums[r];
                        if (lr < cd) {
                            l++;
                        } else if (lr > cd) {
                            r--;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            r--;
                        }
                    }
                }
            }
            return res;
        }
    }
}

class FourSumTest extends AbstractTest<FourSum> {
}
