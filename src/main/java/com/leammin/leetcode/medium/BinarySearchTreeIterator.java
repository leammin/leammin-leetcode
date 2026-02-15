package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 173. 二叉搜索树迭代器
 * 
 * <p>实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。</p>
 * 
 * <p>调用 <code>next()</code> 将返回二叉搜索树中的下一个最小的数。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/25/bst-tree.png" style="height: 178px; width: 189px;"></strong></p>
 * 
 * <pre>BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>next()</code>&nbsp;和&nbsp;<code>hasNext()</code>&nbsp;操作的时间复杂度是&nbsp;O(1)，并使用&nbsp;O(<em>h</em>) 内存，其中&nbsp;<em>h&nbsp;</em>是树的高度。</li>
 * 	<li>你可以假设&nbsp;<code>next()</code>&nbsp;调用总是有效的，也就是说，当调用 <code>next()</code>&nbsp;时，BST 中至少存在一个下一个最小的数。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-30
 */
public abstract class BinarySearchTreeIterator {

    public BinarySearchTreeIterator(TreeNode root) {
    }

    /** @return the next smallest number */
    public abstract int next();

    /** @return whether we have a next smallest number */
    public abstract boolean hasNext();

    static class Solution extends BinarySearchTreeIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        public Solution(TreeNode root) {
            super(root);
            push(root);
        }

        private void push(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public int next() {
            TreeNode top = stack.pop();
            push(top.right);
            return top.val;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    static Testsuite<BinarySearchTreeIterator> testsuite() {
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

class BinarySearchTreeIteratorTest extends AbstractTest<BinarySearchTreeIterator> {
}
