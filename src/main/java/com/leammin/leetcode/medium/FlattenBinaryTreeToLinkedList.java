package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 114. 二叉树展开为链表
 * 
 * <p>给定一个二叉树，<a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95/8010757" target="_blank">原地</a>将它展开为链表。</p>
 * 
 * <p>例如，给定二叉树</p>
 * 
 * <pre>    1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6</pre>
 * 
 * <p>将其展开为：</p>
 * 
 * <pre>1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6</pre>
 * 
 * 
 * @author Leammin
 * @date 2019-10-03
 */
public interface FlattenBinaryTreeToLinkedList {
    void flatten(TreeNode root);

    static Testsuite<FlattenBinaryTreeToLinkedList> testsuite() {
        return Testsuite.<FlattenBinaryTreeToLinkedList>builder()
                .add(ExpectedTestcase.of(
                        t -> {
                            TreeNode root = TreeNode.of(1, 2, 5, 3, 4, null, 6);
                            t.flatten(root);
                            return root;
                        }, TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                ))
                .build();
    }


    class Solution implements FlattenBinaryTreeToLinkedList {

        @Override
        public void flatten(TreeNode root) {
            flattenTail(root);
        }

        private TreeNode flattenTail(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode leftTail = flattenTail(root.left);
            TreeNode rightTail = flattenTail(root.right);
            if (leftTail != null) {
                leftTail.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            return rightTail == null ? leftTail == null ? root : leftTail : rightTail;
        }
    }
}

class FlattenBinaryTreeToLinkedListTest extends AbstractTest<FlattenBinaryTreeToLinkedList> {
}
