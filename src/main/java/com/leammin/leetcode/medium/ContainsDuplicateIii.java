package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.Execute;

import java.util.*;

/**
 * 220. 存在重复元素 III
 *
 * <p>给定一个整数数组，判断数组中是否有两个不同的索引 <em>i</em> 和 <em>j</em>，使得&nbsp;<strong>nums [i]</strong> 和&nbsp;<strong>nums [j]</strong>&nbsp;的差的绝对值最大为 <em>t</em>，并且 <em>i</em> 和 <em>j</em> 之间的差的绝对值最大为 <em>ķ</em>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> nums = [1,2,3,1], k<em> </em>= 3, t = 0
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,5,9,1,5,9], k = 2, t = 3
 * <strong>输出:</strong> false</pre>
 *
 * @author Leammin
 * @date 2021-03-31
 */
public interface ContainsDuplicateIii {
    boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t);

    class Solution implements ContainsDuplicateIii {

        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0 || k <= 0) {
                return false;
            }
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < nums.length; j++) {
                Integer ceiling = set.ceiling(nums[j]);
                Integer floor = set.floor(nums[j]);
                if ((ceiling != null && Math.abs((long) nums[j] - ceiling) <= t)
                        || (floor != null && Math.abs((long) nums[j] - floor) <= t)) {
                    return true;
                }
                set.add(nums[j]);
                if (j >= k) {
                    set.remove(nums[j - k]);
                }
            }
            return false;
        }
    }

    @Execute(value = false)
    class Solution2 implements ContainsDuplicateIii {
        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            List<Integer> sortedIndex = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                sortedIndex.add(i);
            }
            sortedIndex.sort(Comparator.comparingInt(i -> nums[(int) i]).thenComparingInt(i -> (int) i));
            for (int x = 0; x < sortedIndex.size() - 1; x++) {
                int i = sortedIndex.get(x);
                int j = sortedIndex.get(x - 1);
                if (Math.abs(((long) nums[i]) - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution3 implements ContainsDuplicateIii {
        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            if (indexDiff <= 0 || valueDiff < 0) {
                return false;
            }
            TreeSet<Integer> set = new TreeSet<>();
            int l = 0;
            int r = 0;
            while (r < nums.length) {
                if (r > indexDiff) {
                    set.remove(nums[l]);
                    l++;
                }
                Integer ceiling = set.ceiling(nums[r]);
                if (ceiling != null && ceiling - (long) nums[r] <= valueDiff) {
                    return true;
                }
                Integer floor = set.floor(nums[r]);
                if (floor != null && (long) nums[r] - floor <= valueDiff) {
                    return true;
                }
                set.add(nums[r]);
                r++;
            }
            return false;
        }
    }

    class Solution4 implements ContainsDuplicateIii {

        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            if (indexDiff <= 0 || valueDiff < 0) {
                return false;
            }
            Map<Integer, int[]>[] indexBuckets = new Map[nums.length / (indexDiff + 1) + 1];
            for (int i = 0; i < nums.length; i++) {
                int indexBucketIdx = i / (indexDiff + 1);
                Map<Integer, int[]> valueBucket = indexBuckets[indexBucketIdx];
                if (valueBucket == null) {
                    valueBucket = indexBuckets[indexBucketIdx] = new HashMap<>();
                }
                int valueBucketIdx = nums[i] / (valueDiff + 1);
                if (nums[i] < 0) {
                    valueBucketIdx--;
                }
                int[] node = {i, nums[i]};
                if (valueBucket.put(valueBucketIdx, node) != null) {
                    return true;
                }
                if (is(node, valueBucket.get(valueBucketIdx - 1), indexDiff, valueDiff)
                        || is(node, valueBucket.get(valueBucketIdx + 1), indexDiff, valueDiff)
                ) {
                    return true;
                }

                Map<Integer, int[]> preValueBucket = indexBucketIdx > 0 ? indexBuckets[indexBucketIdx - 1] : Collections.emptyMap();
                if (is(node, preValueBucket.get(valueBucketIdx - 1), indexDiff, valueDiff)
                        || is(node, preValueBucket.get(valueBucketIdx + 1), indexDiff, valueDiff)
                        || is(node, preValueBucket.get(valueBucketIdx), indexDiff, valueDiff)
                ) {
                    return true;
                }
            }
            return false;
        }

        private boolean is(int[] a, int[] b, int indexDiff, int valueDiff) {
            return a != null && b != null
                    && Math.abs((long) a[0] - b[0]) <= indexDiff
                    && Math.abs((long) a[1] - b[1]) <= valueDiff;
        }
    }


    class Solution5 implements ContainsDuplicateIii {

        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            if (indexDiff <= 0 || valueDiff < 0) {
                return false;
            }
            Map<Integer, int[]> lastBucket = new HashMap<>();
            Map<Integer, int[]> curBucket = new HashMap<>();
            int curIdx = 0;
            for (int i = 0; i < nums.length; i++) {
                int indexBucketIdx = i / (indexDiff + 1);
                if (indexBucketIdx != curIdx) {
                    lastBucket = curBucket;
                    curBucket = new HashMap<>();
                    curIdx = indexBucketIdx;
                }
                int valueBucketIdx = nums[i] / (valueDiff + 1);
                if (nums[i] < 0) {
                    // 区分 -0 和 +0
                    valueBucketIdx--;
                }
                int[] node = {i, nums[i]};
                if (curBucket.put(valueBucketIdx, node) != null) {
                    return true;
                }
                if (is(node, curBucket.get(valueBucketIdx - 1), indexDiff, valueDiff)
                        || is(node, curBucket.get(valueBucketIdx + 1), indexDiff, valueDiff)
                        || is(node, lastBucket.get(valueBucketIdx - 1), indexDiff, valueDiff)
                        || is(node, lastBucket.get(valueBucketIdx + 1), indexDiff, valueDiff)
                        || is(node, lastBucket.get(valueBucketIdx), indexDiff, valueDiff)
                ) {
                    return true;
                }
            }
            return false;
        }

        private boolean is(int[] a, int[] b, int indexDiff, int valueDiff) {
            return a != null && b != null
                    && Math.abs((long) a[0] - b[0]) <= indexDiff
                    && Math.abs((long) a[1] - b[1]) <= valueDiff;
        }
    }
}
