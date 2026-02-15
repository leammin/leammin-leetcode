package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 572. 另一个树的子树
 * 
 * <p>给定两个非空二叉树 <strong>s</strong> 和 <strong>t</strong>，检验&nbsp;<strong>s</strong> 中是否包含和 <strong>t</strong> 具有相同结构和节点值的子树。<strong>s</strong> 的一个子树包括 <strong>s</strong> 的一个节点和这个节点的所有子孙。<strong>s</strong> 也可以看做它自身的一棵子树。</p>
 * 
 * <p><strong>示例 1:</strong><br />
 * 给定的树 s:</p>
 * 
 * <pre>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * </pre>
 * 
 * <p>给定的树 t：</p>
 * 
 * <pre>
 *    4 
 *   / \
 *  1   2
 * </pre>
 * 
 * <p>返回 <strong>true</strong>，因为 t 与 s 的一个子树拥有相同的结构和节点值。</p>
 * 
 * <p><strong>示例 2:</strong><br />
 * 给定的树 s：</p>
 * 
 * <pre>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * </pre>
 * 
 * <p>给定的树 t：</p>
 * 
 * <pre>
 *    4
 *   / \
 *  1   2
 * </pre>
 * 
 * <p>返回 <strong>false</strong>。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-05-07
 */
public interface SubtreeOfAnotherTree {
    boolean isSubtree(TreeNode s, TreeNode t);

    static Testsuite<SubtreeOfAnotherTree> testsuite() {
        return Testsuite.<SubtreeOfAnotherTree>builder()
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, 2), TreeNode.of(4, 1, 2)), true))
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0), TreeNode.of(4, 1, 2)), false))
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, null, 2), TreeNode.of(3, 1, 2)), false))
                .build();
    }


    class Solution implements SubtreeOfAnotherTree {

        @Override
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == t) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (isSameTree(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == t) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}

class SubtreeOfAnotherTreeTest extends AbstractTest<SubtreeOfAnotherTree> {
}
