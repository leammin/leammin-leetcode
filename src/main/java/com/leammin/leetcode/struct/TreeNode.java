package com.leammin.leetcode.struct;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Leammin
 * @date 2019-04-05
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public static TreeNode of(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int nodeIndex = 1;
        while (!nodes.isEmpty() && nodeIndex < values.length) {
            TreeNode node = nodes.remove();
            node.left = node(values[nodeIndex++]);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (nodeIndex < values.length) {
                node.right = node(values[nodeIndex++]);
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return root;
    }

    private static TreeNode node(Integer val) {
        return val == null ? null : new TreeNode(val);
    }
}
