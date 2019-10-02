package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 
 * <p>给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。</p>
 * 
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 * 
 * <p><strong>示例:</strong><br>
 * 给定如下二叉树，以及目标和&nbsp;<code>sum = 22</code>，</p>
 * 
 * <pre>              <strong>5</strong>
 *              / \
 *             <strong>4</strong>   <strong>8</strong>
 *            /   / \
 *           <strong>11</strong>  13  <strong>4</strong>
 *          /  \    / \
 *         7    <strong>2</strong>  <strong>5</strong>   1
 * </pre>
 * 
 * <p>返回:</p>
 * 
 * <pre>[
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2019-10-02
 */
public interface PathSumII {
    List<List<Integer>> pathSum(TreeNode root, int sum);

    class Solution implements PathSumII {
        @Override
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return Collections.emptyList();
            }
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    return new LinkedList<>(Collections.singletonList(new LinkedList<>(Collections.singletonList(root.val))));
                } else {
                    return new LinkedList<>();
                }
            }
            List<List<Integer>> leftPath = new LinkedList<>();
            List<List<Integer>> rightPath = new LinkedList<>();
            if (root.left != null) {
                leftPath = pathSum(root.left, sum - root.val);
            }
            if (root.right != null) {
                rightPath = pathSum(root.right, sum - root.val);
            }
            List<List<Integer>> result = leftPath;
            result.addAll(rightPath);
            for (List<Integer> path : result) {
                path.add(0, root.val);
            }
            return result;
        }
    }
}
