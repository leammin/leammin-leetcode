package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * <div><p>给定一个整数 <em>n</em>，生成所有由 1 ...&nbsp;<em>n</em> 为节点所组成的<strong>二叉搜索树</strong>。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong>
 * [
 * &nbsp; [1,null,3,2],
 * &nbsp; [3,2,null,1],
 * &nbsp; [3,1,null,null,2],
 * &nbsp; [2,1,3],
 * &nbsp; [1,null,2,null,3]
 * ]
 * <strong>解释:</strong>
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-02
 */
public interface UniqueBinarySearchTreesII {
    List<TreeNode> generateTrees(int n);

    class Solution implements UniqueBinarySearchTreesII {

        @Override
        public List<TreeNode> generateTrees(int n) {

            return null;
        }
    }
}
