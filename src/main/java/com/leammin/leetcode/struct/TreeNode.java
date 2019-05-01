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

    public boolean isBst() {
        return validateBst(this, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBst(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return validateBst(node.left, min, node.val) && validateBst(node.right, node.val, max);
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[").append(this.val);
        int nullTimes = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(this.left);
        nodes.add(this.right);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (node == null) {
                nullTimes++;
            } else {
                for (; nullTimes > 0; nullTimes--) {
                    result.append(",null");
                }
                result.append(",").append(node.val);
                nodes.add(node.left);
                nodes.add(node.right);
            }
        }
        return result.append("]").toString();
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
