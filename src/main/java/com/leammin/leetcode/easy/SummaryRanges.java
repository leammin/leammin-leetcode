package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/summary-ranges/">228. 汇总区间</a>
 *
 * <p>给定一个 &nbsp;<strong>无重复元素</strong> 的&nbsp;<strong>有序</strong> 整数数组 <code>nums</code> 。</p>
 *
 * <p>返回 <em><strong>恰好覆盖数组中所有数字</strong> 的 <strong>最小有序</strong> 区间范围列表&nbsp;</em>。也就是说，<code>nums</code> 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 <code>nums</code> 的数字 <code>x</code> 。</p>
 *
 * <p>列表中的每个区间范围 <code>[a,b]</code> 应该按如下格式输出：</p>
 *
 * <ul>
 * 	<li><code>"a-&gt;b"</code> ，如果 <code>a != b</code></li>
 * 	<li><code>"a"</code> ，如果 <code>a == b</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,1,2,4,5,7]
 * <strong>输出：</strong>["0-&gt;2","4-&gt;5","7"]
 * <strong>解释：</strong>区间范围是：
 * [0,2] --&gt; "0-&gt;2"
 * [4,5] --&gt; "4-&gt;5"
 * [7,7] --&gt; "7"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,2,3,4,6,8,9]
 * <strong>输出：</strong>["0","2-&gt;4","6","8-&gt;9"]
 * <strong>解释：</strong>区间范围是：
 * [0,0] --&gt; "0"
 * [2,4] --&gt; "2-&gt;4"
 * [6,6] --&gt; "6"
 * [8,9] --&gt; "8-&gt;9"
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= nums.length &lt;= 20</code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>nums</code> 中的所有值都 <strong>互不相同</strong></li>
 * 	<li><code>nums</code> 按升序排列</li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2026-02-19
 */
public interface SummaryRanges {
    List<String> summaryRanges(int[] nums);

    static Testsuite<SummaryRanges> testsuite() {
        return Testsuite.<SummaryRanges>builder()
            .addExpected(
                t -> t.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }),
                List.of("0->2", "4->5", "7")
            )
            .addExpected(
                t -> t.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }),
                List.of("0", "2->4", "6", "8->9")
            )
            .build();
    }

    class Solution implements SummaryRanges {

        @Override
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0) {
                return List.of();
            }
            List<String> res = new ArrayList<>();
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == end + 1) {
                    end = nums[i];
                    continue;
                }
                if (start == end) {
                    res.add(Integer.toString(start));
                } else {
                    res.add(start + "->" + end);
                }
                start = end = nums[i];
            }
            if (start == end) {
                res.add(Integer.toString(start));
            } else {
                res.add(start + "->" + end);
            }
            return res;
        }
    }

    class Solution2 implements SummaryRanges {

        @Override
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0) {
                return List.of();
            }
            List<String> res = new ArrayList<>();
            int len = nums.length;
            int i = 0;
            while (i < len) {
                if (i == len - 1 || nums[i] + 1 != nums[i + 1]) {
                    res.add(Integer.toString(nums[i]));
                    i++;
                    continue;
                }

                int left = i + 1;
                int right = len;
                int mid = (left + right) / 2;
                while (left < right) {
                    if (nums[mid] - nums[i] == mid - i) {
                        if (
                            mid + 1 >= len ||
                            nums[mid + 1] - nums[i] != mid + 1 - i
                        ) {
                            break;
                        }
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                    mid = (left + right) / 2;
                }
                res.add(nums[i] + "->" + nums[mid]);
                i = mid + 1;
            }
            return res;
        }
    }

    class Solution3 implements SummaryRanges {

        @Override
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            int left = 0,
                right = 0;
            while (left < nums.length) {
                if (
                    right < nums.length &&
                    nums[right] - nums[left] == right - left
                ) {
                    right++;
                    continue;
                }
                if (left == right - 1) {
                    res.add(Integer.toString(nums[left]));
                } else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
            return res;
        }
    }
}

class SummaryRangesTest extends AbstractTest<SummaryRanges> {}
