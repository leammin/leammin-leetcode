package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 226. 翻转二叉树
 *
 * <p>翻转一棵二叉树。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <p>输入：</p>
 *
 * <pre>     4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9</pre>
 *
 * <p>输出：</p>
 *
 * <pre>     4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1</pre>
 *
 * <p><strong>备注:</strong><br>
 * 这个问题是受到 <a href="https://twitter.com/mxcl" target="_blank">Max Howell </a>的 <a href="https://twitter.com/mxcl/status/608682016205344768" target="_blank">原问题</a> 启发的 ：</p>
 *
 * <blockquote>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。</blockquote>
 *
 * @author Leammin
 * @date 2019-12-29
 */
public interface InvertBinaryTree {
    TreeNode invertTree(TreeNode root);

    static Testsuite<InvertBinaryTree> testsuite() {
        return Testsuite.<InvertBinaryTree>builder()
                .add(ExpectedTestcase.of(s -> s.invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9)), TreeNode.of(4, 7, 2, 9, 6, 3, 1)))
                .build();
    }


    class Solution implements InvertBinaryTree {

        @Override
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}

class InvertBinaryTreeTest extends AbstractTest<InvertBinaryTree> {
}
