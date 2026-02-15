package com.leammin.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.util.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 15. 三数之和
 *
 * <p>给定一个包含 <em>n</em> 个整数的数组&nbsp;<code>nums</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在三个元素 <em>a，b，c ，</em>使得&nbsp;<em>a + b + c = </em>0 ？找出所有满足条件且不重复的三元组。</p>
 *
 * <p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>
 *
 * <pre>例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2019-08-21
 */
public interface ThreeSum {
    List<List<Integer>> threeSum(int[] nums);

    class Solution1 implements ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            List<TwoInt> tiList = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    TwoInt ti = new TwoInt(nums, i, j);
                    tiList.add(ti);
                }
            }
            Map<Integer, List<TwoInt>> tiGroupBySum = tiList.stream().collect(Collectors.groupingBy(TwoInt::sum));
            return IntStream.range(0, nums.length)
                    .mapToObj(i -> tiGroupBySum.getOrDefault(-nums[i], new ArrayList<>())
                            .stream()
                            .filter(ti -> !ti.isIndex(i))
                            .map(ti -> new ThreeInt(nums[i], ti.iVal, ti.jVal)))
                    .flatMap(s -> s)
                    .distinct()
                    .map(ti -> Arrays.asList(ti.a, ti.b, ti.c))
                    .collect(Collectors.toList());
        }

        private static class TwoInt {
            private int iVal;
            private int jVal;

            private int i;
            private int j;

            public TwoInt(int[] nums, int i, int j) {
                this.iVal = nums[i];
                this.jVal = nums[j];
                this.i = i;
                this.j = j;
            }

            public int sum() {
                return iVal + jVal;
            }

            public boolean isIndex(int index) {
                return index == j || index == i;
            }
        }

        private static class ThreeInt {
            private int a;
            private int b;
            private int c;

            public ThreeInt(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof ThreeInt)) {
                    return false;
                }
                ThreeInt threeInt = (ThreeInt) o;
                return (a == threeInt.a && b == threeInt.b && c == threeInt.c)
                        || (a == threeInt.b && b == threeInt.a && c == threeInt.c)
                        || (a == threeInt.c && b == threeInt.b && c == threeInt.a)
                        || (a == threeInt.a && b == threeInt.c && c == threeInt.b)
                        || (a == threeInt.b && b == threeInt.c && c == threeInt.a)
                        || (a == threeInt.c && b == threeInt.a && c == threeInt.b);
            }

            @Override
            public int hashCode() {
                return Objects.hash(a * b * c);
            }
        }
    }

    class Solution2 implements ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, List<Integer>> valMapIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                valMapIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
            Set<ThreeInt> resSet = new HashSet<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int finalI = i;
                    int finalJ = j;
                    valMapIndex.getOrDefault(-(nums[i] + nums[j]), Collections.emptyList())
                            .stream()
                            .filter(index -> index != finalI && index != finalJ)
                            .findAny()
                            .map(index -> new ThreeInt(nums[finalI], nums[finalJ], nums[index]))
                            .ifPresent(resSet::add);
                }
            }
            return resSet.stream().map(ti -> Arrays.asList(ti.a, ti.b, ti.c)).collect(Collectors.toList());
        }

        private static class ThreeInt {
            private int a;
            private int b;
            private int c;

            public ThreeInt(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof ThreeInt)) {
                    return false;
                }
                ThreeInt threeInt = (ThreeInt) o;
                return (a == threeInt.a && b == threeInt.b && c == threeInt.c)
                        || (a == threeInt.b && b == threeInt.a && c == threeInt.c)
                        || (a == threeInt.c && b == threeInt.b && c == threeInt.a)
                        || (a == threeInt.a && b == threeInt.c && c == threeInt.b)
                        || (a == threeInt.b && b == threeInt.c && c == threeInt.a)
                        || (a == threeInt.c && b == threeInt.a && c == threeInt.b);
            }

            @Override
            public int hashCode() {
                return Objects.hash(a * b * c);
            }
        }
    }


    class Solution3 implements ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            Map<Integer, List<Integer>> groupByVal = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                groupByVal.compute(nums[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            }

            List<List<Integer>> res = new ArrayList<>();
            int max = nums[nums.length - 1];
            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int finalI = i;
                int iMax = nums[i] + max;
                for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] <= 0; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (iMax + nums[j] < 0) {
                        continue;
                    }
                    //int k = Arrays.binarySearch(nums, j + 1, nums.length,  -(nums[i] + nums[j]));

                    int finalJ = j;
                    groupByVal.getOrDefault(-(nums[i] + nums[j]), Collections.emptyList())
                            .stream()
                            .filter(index -> index > finalJ && index < nums.length)
                            .findAny()
                            .map(k -> Arrays.asList(nums[finalI], nums[finalJ], nums[k]))
                            .ifPresent(res::add);
                    //if (k > j) {
                    //    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //}
                }
            }
            return res;
        }
    }

    class Best implements ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            // 数组最小值
            int minValue = Integer.MAX_VALUE;
            // 数组最大值
            int maxValue = Integer.MIN_VALUE;
            // 小于0的个数
            int negSize = 0;
            // 大于0的个数
            int posSize = 0;
            // 等于0的个数
            int zeroSize = 0;
            for (int v : nums) {
                if (v < minValue) {
                    minValue = v;
                }
                if (v > maxValue) {
                    maxValue = v;
                }
                if (v > 0) {
                    posSize++;
                } else if (v < 0) {
                    negSize++;
                } else {
                    zeroSize++;
                }
            }
            if (zeroSize >= 3) {
                res.add(Arrays.asList(0, 0, 0));
            }
            if (negSize == 0 || posSize == 0) {
                return res;
            }
            // 缩小最大值和最小值的范围
            if (minValue * 2 + maxValue > 0) {
                maxValue = -minValue * 2;
            } else if (maxValue * 2 + minValue < 0) {
                minValue = -maxValue * 2;
            }

            //　标记各数字出现的次数（减去　minValue）
            int[] map = new int[maxValue - minValue + 1];
            // 数组中的负数
            int[] negs = new int[negSize];
            // 数组中的正数
            int[] poses = new int[posSize];
            negSize = 0;
            posSize = 0;
            for (int v : nums) {
                if (v >= minValue && v <= maxValue) {
                    if (map[v - minValue]++ == 0) {
                        if (v > 0) {
                            poses[posSize++] = v;
                        } else if (v < 0) {
                            negs[negSize++] = v;
                        }
                    }
                }
            }
            Arrays.sort(poses, 0, posSize);
            Arrays.sort(negs, 0, negSize);
            // 正数从 basej 处开始遍历
            int basej = 0;
            // 遍历负数 从大到小
            for (int i = negSize - 1; i >= 0; i--) {
                // 取一个负数
                int nv = negs[i];
                // 最小的正数
                int minp = (-nv) >>> 1;
                // 找到最小正数的基础索引
                while (basej < posSize && poses[basej] < minp) {
                    basej++;
                }
                // 遍历正数 从小到大
                for (int j = basej; j < posSize; j++) {
                    // 取一个正数
                    int pv = poses[j];
                    // 第三个值
                    int cv = 0 - nv - pv;
                    // 必须是 (nv, pv) 之间的值，避免重复，因为如果是 (nv, pv) 之外的值，在后续的遍历中会重复计算。
                    if (cv >= nv && cv <= pv) {
                        if (cv == nv) {
                            // cv 必须有 2 个以上
                            if (map[nv - minValue] > 1) {
                                res.add(Arrays.asList(nv, nv, pv));
                            }
                        } else if (cv == pv) {
                            // cv 必须有 2 个以上
                            if (map[pv - minValue] > 1) {
                                res.add(Arrays.asList(nv, pv, pv));
                            }
                        } else {
                            // 必须存在 cv
                            if (map[cv - minValue] > 0) {
                                res.add(Arrays.asList(nv, cv, pv));
                            }
                        }
                    } else if (cv < nv) {
                        // 正数是从小到大遍历，随着 pv 增大 cv 只会越来越小，一直都会小于 nv
                        // 继续遍历没有意义，因此直接中断正数的遍历
                        break;
                    }
                }
            }
            return res;
        }
    }


    /**
     * 9%
     */
    class Solution4 implements ThreeSum {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>((int) (nums.length / 0.75 + 1.0));
            for (int num : nums) {
                count.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
                int a = nums[i];
                count.compute(a, (k, v) -> v - 1);
                if (i > 0 && a == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] <= 0; j++) {
                    int b = nums[j];
                    count.compute(b, (k, v) -> v - 1);
                    if (j > i + 1 && b == nums[j - 1]) {
                        continue;
                    }
                    if (count.getOrDefault(-a - b, 0) > 0) {
                        res.add(Arrays.asList(a, b, -a - b));
                    }
                }
                for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] <= 0; j++) {
                    count.compute(nums[j], (k, v) -> v + 1);
                }
            }
            return res;
        }
    }

    class Solution5 implements ThreeSum {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int m = nums[nums.length - 1] + nums[nums.length - 2];
            for (int i = bs(nums, 0, nums.length, -m); i < nums.length - 2 && nums[i] <= 0; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int right = nums.length - 1;
                int left = bs(nums, i + 1, right, -(nums[i] + nums[right]));
                while (left < right) {
                    if (nums[left] > -nums[i]) {
                        break;
                    }
                    int s = nums[i] + nums[left] + nums[right];
                    if(s == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    if (s >= 0) {
                        right--;
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    if (s <= 0) {
                        left++;
                        while (left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                    }
                }
            }
            return res;
        }

        private static int bs(int[] nums, int from, int to,  int key) {
            int lo = from;
            int hi = to;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] < key) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}

class ThreeSumTest extends AbstractTest<ThreeSum> {
    @Override
    protected Testsuite<ThreeSum> testsuite() {
        return Testsuite.<ThreeSum>builder()
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4})), sort(Lists.list(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-2, -1, 0, 1, 2, -1, -4})), sort(Lists.list(
                                Lists.newArrayList(-1, 0, 1),
                                Lists.newArrayList(-1, -1, 2),
                                Lists.newArrayList(-2, 0, 2)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{0, 0, 0})), sort(Lists.list(
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{0, 0, 0, 0})), sort(Lists.list(
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .add(ExpectedTestcase.of(
                        t -> sort(t.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0})), sort(Lists.list(
                                // [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
                                Lists.newArrayList(-5, 1, 4),
                                Lists.newArrayList(-4, 0, 4),
                                Lists.newArrayList(-4, 1, 3),
                                Lists.newArrayList(-2, -2, 4),
                                Lists.newArrayList(-2, 1, 1),
                                Lists.newArrayList(0, 0, 0)
                        ))
                ))
                .build();

    }

    private <T extends Comparable<T>> List<List<T>> sort(List<List<T>> lists) {
        for (List<T> list : lists) {
            Collections.sort(list);
        }
        lists.sort((o1, o2) -> {
            Iterator<T> i1 = o1.iterator();
            Iterator<T> i2 = o2.iterator();
            while (i1.hasNext() && i2.hasNext()) {
                T e1 = i1.next();
                T e2 = i2.next();
                int compare = e1.compareTo(e2);
                if (compare != 0) {
                    return compare;
                }
            }
            return i1.hasNext() ? 1 : (i2.hasNext() ? -1 : 0);
        });
        return lists;
    }
}
