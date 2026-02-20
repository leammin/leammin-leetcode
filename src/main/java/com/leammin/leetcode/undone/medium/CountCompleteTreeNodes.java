package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 *
 * <p>给你一棵<strong> 完全二叉树</strong> 的根节点 <code>root</code> ，求出该树的节点个数。</p>
 *
 * <p><a href="https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91/7773232?fr=aladdin">完全二叉树</a> 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 <code>h</code> 层，则该层包含 <code>1~ 2<sup>h</sup></code> 个节点。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg" style="width: 372px; height: 302px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3,4,5,6]
 * <strong>输出：</strong>6
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = []
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li>树中节点的数目范围是<code>[0, 5 * 10<sup>4</sup>]</code></li>
 * 	<li><code>0 <= Node.val <= 5 * 10<sup>4</sup></code></li>
 * 	<li>题目数据保证输入的树是 <strong>完全二叉树</strong></li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>进阶：</strong>遍历树来统计节点是一种时间复杂度为 <code>O(n)</code> 的简单解决方案。你可以设计一个更快的算法吗？</p>
 *
 *
 * @author Leammin
 * @date 2026-02-19
 */
public interface CountCompleteTreeNodes {
    int countNodes(TreeNode root);

    static Testsuite<CountCompleteTreeNodes> testsuite() {
        return Testsuite.<CountCompleteTreeNodes>builder()
            .addExpected(t -> t.countNodes(TreeNode.of(1, 2, 3, 4, 5, 6)), 6)
            .addExpected(t -> t.countNodes(TreeNode.of(1)), 1)
            .addExpected(t -> t.countNodes(TreeNode.of()), 0)
            .build();
    }

    class Solution implements CountCompleteTreeNodes {

        @Override
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    class Solution2 implements CountCompleteTreeNodes {

        @Override
        public int countNodes(TreeNode root) {
            return 0;
        }
    }
}

class CountCompleteTreeNodesTest extends AbstractTest<CountCompleteTreeNodes> {}
