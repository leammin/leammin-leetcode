package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 112. 路径总和
 *
 * <p>给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。</p>
 *
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 *
 * <p><strong>示例:</strong>&nbsp;<br>
 * 给定如下二叉树，以及目标和 <code>sum = 22</code>，</p>
 *
 * <pre>              <strong>5</strong>
 *              / \
 *             <strong>4 </strong>  8
 *            /   / \
 *           <strong>11 </strong> 13  4
 *          /  \      \
 *         7    <strong>2</strong>      1
 * </pre>
 *
 * <p>返回 <code>true</code>, 因为存在目标和为 22 的根节点到叶子节点的路径 <code>5-&gt;4-&gt;11-&gt;2</code>。</p>
 *
 *
 * @author Leammin
 * @date 2019-10-02
 */
public interface PathSum {
    boolean hasPathSum(TreeNode root, int sum);

    static Testsuite<PathSum> testsuite() {
        return Testsuite.<PathSum>builder()
                .add(ExpectedTestcase.of(t -> t.hasPathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22), true))
                .add(ExpectedTestcase.of(t -> t.hasPathSum(TreeNode.of(1,2), 1), false))
                .build();
    }


    class Solution implements PathSum {
        @Override
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            if (root.left == null) {
                return hasPathSum(root.right, sum - root.val);
            }
            if (root.right == null) {
                return hasPathSum(root.left, sum - root.val);
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}

class PathSumTest extends AbstractTest<PathSum> {
}
