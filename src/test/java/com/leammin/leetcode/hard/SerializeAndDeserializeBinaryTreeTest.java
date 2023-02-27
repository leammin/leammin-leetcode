package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class SerializeAndDeserializeBinaryTreeTest extends AbstractTest<SerializeAndDeserializeBinaryTree> {
    @Override
    protected Testsuite<SerializeAndDeserializeBinaryTree> testsuite() {
        return Testsuite.<SerializeAndDeserializeBinaryTree>builder()
                .add(ExpectedTestcase.of(s -> s.serialize(s.deserialize("0,null,1,2,3")), "0,null,1,2,3"
                ))
                .add(ExpectedTestcase.of(s -> s.serialize(s.deserialize("0,1,null,2,3")), "0,1,null,2,3"
                ))
                .add(ExpectedTestcase.of(s -> s.serialize(s.deserialize("5,4,7,3,null,2,null,-1,null,9")), "5,4,7,3,null,2,null,-1,null,9"
                ))
                .build();
    }
}