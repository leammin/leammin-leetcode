package com.leammin.leetcode.undone.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 15. 三数之和
 *
 * <div><p>Given an array <code>nums</code> of <em>n</em> integers, are there elements <em>iVal</em>, <em>jVal</em>, <em>c</em> in <code>nums</code> such that <em>iVal</em> + <em>jVal</em> + <em>c</em> = 0? Find all unique triplets in the array which gives the sum of zero.</p>
 *
 * <p><strong>Note:</strong></p>
 *
 * <p>The solution set must not contain duplicate triplets.</p>
 *
 * <p><strong>Example:</strong></p>
 *
 * <pre>Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-11-03
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

    class Solution4 implements ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            int negSize = 0;
            int posSize = 0;
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
            if (minValue * 2 + maxValue > 0) {
                maxValue = -minValue * 2;
            } else if (maxValue * 2 + minValue < 0) {
                minValue = -maxValue * 2;
            }

            int[] map = new int[maxValue - minValue + 1];
            int[] negs = new int[negSize];
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
            int basej = 0;
            for (int i = negSize - 1; i >= 0; i--) {
                int nv = negs[i];
                int minp = (-nv) >>> 1;
                while (basej < posSize && poses[basej] < minp) {
                    basej++;
                }
                for (int j = basej; j < posSize; j++) {
                    int pv = poses[j];
                    int cv = 0 - nv - pv;
                    if (cv >= nv && cv <= pv) {
                        if (cv == nv) {
                            if (map[nv - minValue] > 1) {
                                res.add(Arrays.asList(nv, nv, pv));
                            }
                        } else if (cv == pv) {
                            if (map[pv - minValue] > 1) {
                                res.add(Arrays.asList(nv, pv, pv));
                            }
                        } else {
                            if (map[cv - minValue] > 0) {
                                res.add(Arrays.asList(nv, cv, pv));
                            }
                        }
                    } else if (cv < nv) {
                        break;
                    }
                }
            }
            return res;
        }
    }
}
