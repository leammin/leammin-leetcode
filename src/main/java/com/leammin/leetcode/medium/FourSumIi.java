package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * <p>给定四个包含整数的数组列表&nbsp;A , B , C , D ,计算有多少个元组 <code>(i, j, k, l)</code>&nbsp;，使得&nbsp;<code>A[i] + B[j] + C[k] + D[l] = 0</code>。</p>
 *
 * <p>为了使问题简单化，所有的 A, B, C, D 具有相同的长度&nbsp;N，且 0 &le; N &le; 500 。所有整数的范围在 -2<sup>28</sup> 到 2<sup>28</sup> - 1 之间，最终结果不会超过&nbsp;2<sup>31</sup> - 1 。</p>
 *
 * <p><strong>例如:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * <strong>输出:</strong>
 * 2
 *
 * <strong>解释:</strong>
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -&gt; A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -&gt; A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * </pre>
 *
 * @author Leammin
 * @date 2020-06-28
 */
public interface FourSumIi {
    int fourSumCount(int[] A, int[] B, int[] C, int[] D);

    class Solution implements FourSumIi {

        @Override
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> dMap = new HashMap<>((int) (D.length / 0.75f + 1.0f));
            for (int l : D) {
                dMap.compute(l, (k, v) -> v == null ? 1 : v + 1);
            }
            int res = 0;
            for (int a : A) {
                for (int b : B)
                    for (int c : C) {
                        res += dMap.getOrDefault(-(a + b + c), 0);
                    }
            }
            return res;
        }
    }

    class Solution2 implements FourSumIi {

        @Override
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> aMap = getMap(A);
            Map<Integer, Integer> bMap = getMap(B);
            Map<Integer, Integer> cMap = getMap(C);
            Map<Integer, Integer> dMap = getMap(D);
            int res = 0;
            for (Map.Entry<Integer, Integer> aEntry : aMap.entrySet()) {
                for (Map.Entry<Integer, Integer> bEntry : bMap.entrySet()) {
                    for (Map.Entry<Integer, Integer> cEntry : cMap.entrySet()) {
                        res += aEntry.getValue() * bEntry.getValue() * cEntry.getValue()
                                * dMap.getOrDefault(-(aEntry.getKey() + bEntry.getKey() + cEntry.getKey()), 0);
                    }
                }
            }
            return res;
        }

        private Map<Integer, Integer> getMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75f + 1.0f));
            for (int num : nums) {
                map.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
            return map;
        }
    }

    class Solution3 implements FourSumIi {

        @Override
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> abMap = getMap(A, B);
            Map<Integer, Integer> cdMap = getMap(C, D);
            int res = 0;
            for (Map.Entry<Integer, Integer> abEntry : abMap.entrySet()) {
                res += abEntry.getValue() * cdMap.getOrDefault(-abEntry.getKey(), 0);
            }
            return res;
        }


        private Map<Integer, Integer> getMap(int[] a, int[] b) {
            Map<Integer, Integer> map = new HashMap<>((int) (a.length * a.length / 0.75f + 1.0f));
            for (int i : a) {
                for (int j : b) {
                    map.compute(i + j, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            return map;
        }
    }

    class Solution4 implements FourSumIi {

        @Override
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> aMap = getMap(A);
            Map<Integer, Integer> bMap = getMap(B);
            Map<Integer, Integer> cdMap = getMap(C, D);
            int res = 0;
            for (Map.Entry<Integer, Integer> aEntry : aMap.entrySet()) {
                for (Map.Entry<Integer, Integer> bEntry : bMap.entrySet()) {
                    res += aEntry.getValue() * bEntry.getValue()
                            * cdMap.getOrDefault(-(aEntry.getKey() + bEntry.getKey()), 0);
                }
            }
            return res;
        }

        private Map<Integer, Integer> getMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75f + 1.0f));
            for (int num : nums) {
                map.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
            return map;
        }

        private Map<Integer, Integer> getMap(int[] a, int[] b) {
            Map<Integer, Integer> map = new HashMap<>((int) (a.length * a.length / 0.75f + 1.0f));
            for (int i : a) {
                for (int j : b) {
                    map.compute(i + j, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            return map;
        }
    }

    class Solution5 implements FourSumIi {

        @Override
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> cdMap = getMap(C, D);
            int res = 0;
            for (int a : A) {
                for (int b : B)
                    res += cdMap.getOrDefault(-(a + b), 0);
            }
            return res;
        }


        private Map<Integer, Integer> getMap(int[] a, int[] b) {
            Map<Integer, Integer> map = new HashMap<>((int) (a.length * a.length / 0.75f + 1.0f));
            for (int i : a) {
                for (int j : b) {
                    map.compute(i + j, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            return map;
        }
    }
}
