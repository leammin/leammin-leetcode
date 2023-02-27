package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2021-02-11
 */
class KthLargestElementInAStreamTest extends AbstractTest<KthLargestElementInAStream> {
    @Override
    protected Testsuite<KthLargestElementInAStream> testsuite() {
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