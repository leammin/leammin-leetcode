package com.leammin.leetcode.undone.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 
 * <p>给定一个<strong>无重复元素</strong>的数组&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>
 * 
 * <p><code>candidates</code>&nbsp;中的数字可以无限制重复被选取。</p>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>所有数字（包括&nbsp;<code>target</code>）都是正整数。</li>
 * 	<li>解集不能包含重复的组合。&nbsp;</li>
 * </ul>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> candidates = <code>[2,3,6,7], </code>target = <code>7</code>,
 * <strong>所求解集为:</strong>
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> candidates = [2,3,5]<code>, </code>target = 8,
 * <strong>所求解集为:</strong>
 * [
 * &nbsp; [2,2,2,2],
 * &nbsp; [2,3,3],
 * &nbsp; [3,5]
 * ]</pre>
 * 
 * 
 * @author Leammin
 * @date 2023-02-01
 */
public interface CombinationSum {
    List<List<Integer>> combinationSum(int[] candidates, int target);

    class Solution implements CombinationSum {

        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return List.copyOf(dynamic(new HashMap<>(), candidates, target));
        }

        private Set<List<Integer>> dynamic(Map<Integer, Set<List<Integer>>> table, int[] candidates, int target) {
            if (table.containsKey(target)) {
                return table.get(target);
            }
            Set<List<Integer>> result = new HashSet<>();
            for (int candidate : candidates) {
                if (target < candidate) {
                    continue;
                }
                if (target == candidate) {
                    result.add(List.of(candidate));
                    continue;
                }
                Set<List<Integer>> ds = dynamic(table, candidates, target - candidate);
                for (List<Integer> d : ds) {
                    List<Integer> n = new ArrayList<>(d.size() + 1);
                    n.addAll(d);
                    n.add(candidate);
                    Collections.sort(n);
                    result.add(n);
                }
            }
            table.put(target, result);
            return result;
        }
    }

    class Solution2 implements CombinationSum {

        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            return combination(candidates, target, 0);
        }

        private List<List<Integer>> combination(int[] candidates, int target, int fromIndex) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = fromIndex; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (target < candidate) {
                    break;
                }
                if (candidate == target) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(candidate);
                    result.add(l);
                    break;
                }
                List<List<Integer>> c = combination(candidates, target - candidate, i);
                for (List<Integer> l : c) {
                    l.add(candidate);
                }
                result.addAll(c);
            }
            return result;
        }
    }
}

class CombinationSumTest extends AbstractTest<CombinationSum> {
    @Override
    protected Testsuite<CombinationSum> testsuite() {
        return Testsuite.<CombinationSum>builder()
                .addExpected(t -> sort(t.combinationSum(new int[]{2, 3, 6, 7}, 7)), List.of(List.of(2, 2, 3), List.of(7)))
                .addExpected(t -> sort(t.combinationSum(new int[]{2, 3, 5}, 8)), List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)))
                .addExpected(t -> sort(t.combinationSum(new int[]{8,7,4,3}, 11)), List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)))
                .build();
    }

    private List<List<Integer>> sort(List<List<Integer>> r) {
        return r.stream().map(l -> l.stream().sorted().toList()).sorted((o1, o2) -> Arrays.compare(o1.toArray(Integer[]::new), o2.toArray(Integer[]::new))).toList();
    }
}
