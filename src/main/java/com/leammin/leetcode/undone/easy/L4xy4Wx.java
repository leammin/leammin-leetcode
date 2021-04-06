package com.leammin.leetcode.undone.easy;

import java.util.Arrays;

/**
 * LCP 28. 采购方案
 * 
 * 小力将 N 个零件的报价存于数组 `nums`。小力预算为 `target`，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * 
 * 注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
 * 
 * 
 * **示例 1：**
 * >输入：`nums = [2,5,3,5], target = 6`
 * >
 * >输出：`1`
 * >
 * >解释：预算内仅能购买 nums[0] 与 nums[2]。
 * 
 * **示例 2：**
 * >输入：`nums = [2,2,1,9], target = 10`
 * >
 * >输出：`4`
 * >
 * >解释：符合预算的采购方案如下：
 * >nums[0] + nums[1] = 4
 * >nums[0] + nums[2] = 3
 * >nums[1] + nums[2] = 3
 * >nums[2] + nums[3] = 10
 * 
 * **提示：**
 * - `2 <= nums.length <= 10^5`
 * - `1 <= nums[i], target <= 10^5`
 * 
 * 
 * @author Leammin
 * @date 2021-04-05
 */
public interface L4xy4Wx {
    int purchasePlans(int[] nums, int target);

    class Solution implements L4xy4Wx {

        @Override
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] + nums[0] > target) {
                    break;
                }
                int s = target - nums[i];
                int bs = binarySearch(nums, s);
                if (bs > i) {
                    res += bs - i;
                }
            }
            return (int) res % 1000000007;
        }

        private int binarySearch(int[] arr, int target) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);
                if (arr[mid] > target) r = mid - 1;
                else l = mid;
            }
            return l;
        }
    }

    class Solution2 implements L4xy4Wx {

        @Override
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            long res = 0;
            int l = 0, r = nums.length - 1;
            while (r > l) {
                if (nums[r] + nums[l] > target) {
                    r--;
                } else {
                    l++;
                    res += l;
                }
            }
            return (int) res % 1000000007;
        }

    }
}
