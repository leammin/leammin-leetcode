package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-30
 */
class BinarySearchTreeIteratorTest extends AbstractTest<BinarySearchTreeIterator> {
    @Override
    protected Testsuite<BinarySearchTreeIterator> testsuite() {
        return Testsuite.<BinarySearchTreeIterator>builder()
                .add(Testcase.create(c -> ClassUtils.newInstance(c, TreeNode.of(7,3,15,null,null,9,20)), t -> {
                    long before = System.nanoTime();
                    int r1 = t.next();// 返回 3
                    int r2 = t.next();    // 返回 7
                    boolean b1 = t.hasNext();// 返回 true
                    int r3 = t.next();    // 返回 9
                    boolean b2 = t.hasNext(); // 返回 true
                    int r4 = t.next();    // 返回 15
                    boolean b3 = t.hasNext(); // 返回 true
                    int r5 = t.next();    // 返回 20
                    boolean b4 = t.hasNext(); // 返回 false
                    long after = System.nanoTime();

                    Assertions.assertThat(r1).isEqualTo(3);
                    Assertions.assertThat(r2).isEqualTo(7);
                    Assertions.assertThat(r3).isEqualTo(9);
                    Assertions.assertThat(r4).isEqualTo(15);
                    Assertions.assertThat(r5).isEqualTo(20);
                    Assertions.assertThat(b1).isTrue();
                    Assertions.assertThat(b2).isTrue();
                    Assertions.assertThat(b3).isTrue();
                    Assertions.assertThat(b4).isFalse();

                    return after - before;
                }))
                .build();
    }
}