package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 100. 相同的树
 * 
 * <p>给定两个二叉树，编写一个函数来检验它们是否相同。</p>
 * 
 * <p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入: </strong>      1         1
 *           / \       / \
 *          2   3     2   3
 * 
 *         [1,2,3],   [1,2,3]
 * 
 * <strong>输出:</strong> true</pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:  </strong>    1          1
 *           /           \
 *          2             2
 * 
 *         [1,2],     [1,null,2]
 * 
 * <strong>输出:</strong> false
 * </pre>
 * 
 * <p><strong>示例&nbsp;3:</strong></p>
 * 
 * <pre><strong>输入:</strong>       1         1
 *           / \       / \
 *          2   1     1   2
 * 
 *         [1,2,1],   [1,1,2]
 * 
 * <strong>输出:</strong> false
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2019-09-22
 */
public interface SameTree {
    boolean isSameTree(TreeNode p, TreeNode q);

    static Testsuite<SameTree> testsuite() {
        return Testsuite.<SameTree>builder()
                .add(ExpectedTestcase.of(t -> t.isSameTree(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3)), true))
                .add(ExpectedTestcase.of(t -> t.isSameTree(TreeNode.of(1, 2), TreeNode.of(1, null, 2)), false))
                .add(ExpectedTestcase.of(t -> t.isSameTree(TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2)), false))
                .build();
    }


    class Solution implements SameTree {

        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

class SameTreeTest extends AbstractTest<SameTree> {
}
