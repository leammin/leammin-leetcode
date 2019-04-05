package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * <div><p>将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。</p>
 *
 * <p>本题中，一个高度平衡二叉树是指一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过 1。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface ConvertSortedArrayToBinarySearchTree {
    TreeNode sortedArrayToBST(int[] nums);

    class Solution implements ConvertSortedArrayToBinarySearchTree {
        @Override
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
            if (startIndex < 0 || startIndex >= nums.length || endIndex < 0 || endIndex >= nums.length || startIndex > endIndex) {
                return null;
            }
            if (startIndex == endIndex) {
                return new TreeNode(nums[startIndex]);
            }
            int mid = (startIndex + endIndex) / 2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = sortedArrayToBST(nums, startIndex, mid - 1);
            head.right = sortedArrayToBST(nums, mid + 1, endIndex);
            return head;
        }
    }


}
