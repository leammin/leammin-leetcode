package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 * 
 * <p>实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。</p>
 * 
 * <p>调用 <code>next()</code> 将返回二叉搜索树中的下一个最小的数。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/25/bst-tree.png" style="height: 178px; width: 189px;"></strong></p>
 * 
 * <pre>BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>next()</code>&nbsp;和&nbsp;<code>hasNext()</code>&nbsp;操作的时间复杂度是&nbsp;O(1)，并使用&nbsp;O(<em>h</em>) 内存，其中&nbsp;<em>h&nbsp;</em>是树的高度。</li>
 * 	<li>你可以假设&nbsp;<code>next()</code>&nbsp;调用总是有效的，也就是说，当调用 <code>next()</code>&nbsp;时，BST 中至少存在一个下一个最小的数。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-30
 */
public abstract class BinarySearchTreeIterator {

    public BinarySearchTreeIterator(TreeNode root) {
    }

    /** @return the next smallest number */
    public abstract int next();

    /** @return whether we have a next smallest number */
    public abstract boolean hasNext();

    static class Solution extends BinarySearchTreeIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        public Solution(TreeNode root) {
            super(root);
            push(root);
        }

        private void push(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public int next() {
            TreeNode top = stack.pop();
            push(top.right);
            return top.val;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
