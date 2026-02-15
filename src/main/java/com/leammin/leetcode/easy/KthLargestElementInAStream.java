package com.leammin.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 703. 数据流中的第K大元素
 * 
 * <p>设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。</p>
 * 
 * <p>你的&nbsp;<code>KthLargest</code>&nbsp;类需要一个同时接收整数&nbsp;<code>k</code> 和整数数组<code>nums</code>&nbsp;的构造器，它包含数据流中的初始元素。每次调用&nbsp;<code>KthLargest.add</code>，返回当前数据流中第K大的元素。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);&nbsp; &nbsp;// returns 4
 * kthLargest.add(5);&nbsp; &nbsp;// returns 5
 * kthLargest.add(10);&nbsp; // returns 5
 * kthLargest.add(9);&nbsp; &nbsp;// returns 8
 * kthLargest.add(4);&nbsp; &nbsp;// returns 8
 * </pre>
 * 
 * <p><strong>说明: </strong><br />
 * 你可以假设&nbsp;<code>nums</code>&nbsp;的长度&ge;&nbsp;<code>k-1</code>&nbsp;且<code>k</code> &ge;&nbsp;1。</p>
 * 
 * 
 * @author Leammin
 * @date 2021-02-11
 */
public abstract class KthLargestElementInAStream {

    KthLargestElementInAStream(int k, int[] nums) {

    }

    public abstract int add(int val);

    static class Solution extends KthLargestElementInAStream {
        Queue<Integer> heap;
        int k;

        Solution(int k, int[] nums) {
            super(k, nums);
            this.k = k;
            this.heap = new PriorityQueue<>(Math.max(11, nums.length), Comparator.reverseOrder());
            for (int num : nums) {
                heap.add(num);
            }
        }

        @Override
        public int add(int val) {
            heap.add(val);
            List<Integer> tmp = new ArrayList<>(k);
            for (int i = 0; i < k - 1; i++) {
                tmp.add(heap.poll());
            }
            int res = heap.peek();
            heap.addAll(tmp);
            return res;
        }
    }

    static class Solution2 extends KthLargestElementInAStream {
        List<Integer> nums;
        int k;

        Solution2(int k, int[] nums) {
            super(k, nums);
            this.k = k;
            this.nums = Arrays.stream(nums)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
        }

        @Override
        public int add(int val) {
            int bs = Collections.binarySearch(nums, val);
            if (bs < 0) {
                bs = -bs - 1;
            }
            nums.add(bs, val);
            return nums.get(nums.size() - k);
        }
    }

    static class Solution3 extends KthLargestElementInAStream {
        Queue<Integer> heap;
        int k;

        Solution3(int k, int[] nums) {
            super(k, nums);
            this.k = k;
            this.heap = new PriorityQueue<>(k + 1);
            for (int num : nums) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        @Override
        public int add(int val) {
            heap.add(val);
            if (heap.size() > k) {
                heap.poll();
            }
            return heap.peek();
        }
    }

    static Testsuite<KthLargestElementInAStream> testsuite() {
        return Testsuite.<KthLargestElementInAStream>builder()
                .add(Testcase.create(clazz -> ClassUtils.newInstance(clazz, 3, (Object) new int[]{4, 5, 8, 2}),
                        solution -> {
                            String name = ClassUtils.getName(solution);
//                            kthLargest.add(3);   // returns 4
//                            kthLargest.add(5);   // returns 5
//                            kthLargest.add(10);  // returns 5
//                            kthLargest.add(9);   // returns 8
//                            kthLargest.add(4);   // returns 8
                            long before = System.nanoTime();
                            int a = solution.add(3);
                            int b = solution.add(5);
                            int c = solution.add(10);
                            int d = solution.add(9);
                            int e = solution.add(4);
                            long time = System.nanoTime() - before;

                            Assertions.assertThat(a).as(name).isEqualTo(4);
                            Assertions.assertThat(b).as(name).isEqualTo(5);
                            Assertions.assertThat(c).as(name).isEqualTo(5);
                            Assertions.assertThat(d).as(name).isEqualTo(8);
                            Assertions.assertThat(e).as(name).isEqualTo(8);
                            return time;
                        }))
                .build();
    }
}

class KthLargestElementInAStreamTest extends AbstractTest<KthLargestElementInAStream> {
}
