package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class SerializeAndDeserializeBinaryTreeTest extends AbstractTest<SerializeAndDeserializeBinaryTree> {

    @Override
    protected Testsuite<SerializeAndDeserializeBinaryTree> testsuite() {
        TreeNode root = new TreeNode(0);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        return Testsuite.<SerializeAndDeserializeBinaryTree>builder()
                .add(EqualTestcase.of("0,null,1,2,3", s -> s.serialize(root)))
                .add(EqualTestcase.of(root, s -> s.deserialize("0,null,1,2,3")))
                .build();
    }
}