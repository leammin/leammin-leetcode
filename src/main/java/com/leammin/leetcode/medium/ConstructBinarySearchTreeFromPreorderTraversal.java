package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 1050. 先序遍历构造二叉树
 * 
 * <p>返回与给定先序遍历&nbsp;<code>preorder</code> 相匹配的二叉搜索树（binary <strong>search</strong> tree）的根结点。</p>
 * 
 * <p><em>(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于&nbsp;<code>node.left</code>&nbsp;的任何后代，值总 <code>&lt;</code> <code>node.val</code>，而 <code>node.right</code> 的任何后代，值总 <code>&gt;</code> <code>node.val</code>。此外，先序遍历首先显示节点的值，然后遍历 <code>node.left</code>，接着遍历 <code>node.right</code>。）</em></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre><strong>输入：</strong>[8,5,1,7,10,12]
 * <strong>输出：</strong>[8,5,10,1,7,null,12]
 * <img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/03/08/1266.png" style="height: 200px; width: 306px;">
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= preorder.length &lt;= 100</code></li>
 * 	<li>先序&nbsp;<code>preorder</code>&nbsp;中的值是不同的。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-12-30
 */
public interface ConstructBinarySearchTreeFromPreorderTraversal {
    TreeNode bstFromPreorder(int[] preorder);

    class Solution implements ConstructBinarySearchTreeFromPreorderTraversal {

        @Override
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null) {
                return null;
            }
            return bstFromPreorder(preorder, 0, preorder.length);
        }

        private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
            if (start >= end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[start]);
            int leftMax = end;
            for (int i = start + 1; i < end; i++) {
                if (preorder[i] > preorder[start]) {
                    leftMax = i;
                    break;
                }
            }
            root.left = bstFromPreorder(preorder, start + 1, leftMax);
            root.right = bstFromPreorder(preorder, leftMax, end);
            return root;
        }
    }
}
