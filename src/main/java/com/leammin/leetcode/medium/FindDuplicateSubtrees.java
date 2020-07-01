package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 *
 * <p>给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意<strong>一棵</strong>的根结点即可。</p>
 *
 * <p>两棵树重复是指它们具有相同的结构以及相同的结点值。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>        1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * </pre>
 *
 * <p>下面是两个重复的子树：</p>
 *
 * <pre>      2
 *      /
 *     4
 * </pre>
 *
 * <p>和</p>
 *
 * <pre>    4
 * </pre>
 *
 * <p>因此，你需要以列表的形式返回上述重复子树的根结点。</p>
 *
 * @author Leammin
 * @date 2020-06-28
 */
public interface FindDuplicateSubtrees {
    List<TreeNode> findDuplicateSubtrees(TreeNode root);

    class Solution implements FindDuplicateSubtrees {

        @Override
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            preAndInOrderToMap(root, new HashMap<>(), res);
            return res;
        }

        private List<String> preAndInOrderToMap(TreeNode root, Map<List<String>, List<TreeNode>> map, List<TreeNode> res) {
            if (root == null) {
                return List.of("n", "n");
            }
            List<String> left = preAndInOrderToMap(root.left, map, res);
            List<String> right = preAndInOrderToMap(root.right, map, res);
            List<String> key = List.of(root.val + "," + left.get(0) + right.get(0), left.get(1) + root.val + "," + right.get(1));
            map.compute(key, (k, v) -> {
                if (v == null) {
                    return Collections.singletonList(root);
                }
                if (!v.isEmpty()) {
                    res.add(root);
                }
                return Collections.emptyList();
            });
            return key;
        }
    }

    class Solution2 implements FindDuplicateSubtrees {

        @Override
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            preAndInOrderToMap(root, new HashMap<>(), res);
            return res;
        }

        private String preAndInOrderToMap(TreeNode root, Map<String, List<TreeNode>> map, List<TreeNode> res) {
            if (root == null) {
                return "n";
            }
            String left = preAndInOrderToMap(root.left, map, res);
            String right = preAndInOrderToMap(root.right, map, res);
            String key = root.val + "," + left + right;
            map.compute(key, (k, v) -> {
                if (v == null) {
                    return Collections.singletonList(root);
                }
                if (!v.isEmpty()) {
                    res.add(root);
                }
                return Collections.emptyList();
            });
            return key;
        }
    }
}
