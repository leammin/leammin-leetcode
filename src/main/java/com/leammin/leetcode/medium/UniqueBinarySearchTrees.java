package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 96. 不同的二叉搜索树
 *
 * <div><p>给定一个整数 <em>n</em>，求以&nbsp;1 ...&nbsp;<em>n</em>&nbsp;为节点组成的二叉搜索树有多少种？</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong> 5
 * <strong>解释:
 * </strong>给定 <em>n</em> = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3</pre>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-24
 */
public interface UniqueBinarySearchTrees {
    int numTrees(int n);

    static Testsuite<UniqueBinarySearchTrees> testsuite() {
        return Testsuite.<UniqueBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(s -> s.numTrees(1), 1))
                .add(ExpectedTestcase.of(s -> s.numTrees(2), 2))
                .add(ExpectedTestcase.of(s -> s.numTrees(3), 5))
                .add(ExpectedTestcase.of(s -> s.numTrees(4), 14))
                .add(ExpectedTestcase.of(s -> s.numTrees(5), 42))
                .add(ExpectedTestcase.of(s -> s.numTrees(6), 132))
                .add(ExpectedTestcase.of(s -> s.numTrees(7), 429))
                .add(ExpectedTestcase.of(s -> s.numTrees(8), 1430))
                .add(ExpectedTestcase.of(s -> s.numTrees(9), 4862))
                .add(ExpectedTestcase.of(s -> s.numTrees(10), 16796))
                .add(ExpectedTestcase.of(s -> s.numTrees(15), 9694845))
                .add(ExpectedTestcase.of(s -> s.numTrees(16), 35357670))
                .add(ExpectedTestcase.of(s -> s.numTrees(17), 129644790))
                .add(ExpectedTestcase.of(s -> s.numTrees(18), 477638700))
                .add(ExpectedTestcase.of(s -> s.numTrees(19), 1767263190))
                .build();
    }


    class Solution implements UniqueBinarySearchTrees {
        @Override
        public int numTrees(int n) {
            return tree(n, new int[n]);
        }

        private int tree(int n, int[] cache) {
            if (n == 0) {
                return 1;
            }
            if (cache[n - 1] != 0) {
                return cache[n - 1];
            }
            int sum = 0;
            for (int left = 0; left < n; left++) {
                sum += tree(left, cache) * tree(n - 1 - left, cache);
            }
            return cache[n - 1] = sum;
        }
    }
}

class UniqueBinarySearchTreesTest extends AbstractTest<UniqueBinarySearchTrees> {
}
