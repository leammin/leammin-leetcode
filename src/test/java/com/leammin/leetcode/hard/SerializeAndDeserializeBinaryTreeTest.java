package com.leammin.leetcode.hard;

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
        return Testsuite.<SerializeAndDeserializeBinaryTree>builder()
                .add(EqualTestcase.of("0,null,1,2,3", s -> s.serialize(s.deserialize("0,null,1,2,3"))))
                .build();
    }
}