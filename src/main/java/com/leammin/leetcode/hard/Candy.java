package com.leammin.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 135. 分发糖果
 * 
 * <p>老师想给孩子们分发糖果，有 <em>N</em>&nbsp;个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。</p>
 * 
 * <p>你需要按照以下要求，帮助老师给这些孩子分发糖果：</p>
 * 
 * <ul>
 * 	<li>每个孩子至少分配到 1 个糖果。</li>
 * 	<li>相邻的孩子中，评分高的孩子必须获得更多的糖果。</li>
 * </ul>
 * 
 * <p>那么这样下来，老师至少需要准备多少颗糖果呢？</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,0,2]
 * <strong>输出:</strong> 5
 * <strong>解释:</strong> 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,2,2]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。</pre>
 * 
 * 
 * @author Leammin
 * @date 2019-09-04
 */
public interface Candy {
    int candy(int[] ratings);

    /**
     * 时间复杂度 nlogn
     * 空间复杂度 n
     */

    static Testsuite<Candy> testsuite() {
        return Testsuite.<Candy>builder()
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,0,2}), 5))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,2,2}), 4))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,3,2,2,1}), 7))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,6,10,8,7,3,2}), 18))
                .build();
    }

    class Solution implements Candy {

        @Override
        public int candy(int[] ratings) {
            Child[] children = new Child[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                children[i] = new Child(i, ratings[i]);
            }
            Child[] sorted = children.clone();
            Arrays.sort(sorted, Comparator.comparingInt(c -> c.rating));
            for (Child child : sorted) {
                if (child.candy == 0) {
                    child.candy = 1;
                }
                if (child.index + 1 < children.length && children[child.index + 1].rating > child.rating) {
                    children[child.index + 1].candy = Math.max(child.candy + 1, children[child.index + 1].candy);
                }
                if (child.index - 1 >= 0 && children[child.index - 1].rating > child.rating) {
                    children[child.index - 1].candy = Math.max(child.candy + 1, children[child.index - 1].candy);
                }
            }
            int res = 0;
            for (Child child : children) {
                res += child.candy;
            }
            return res;
        }

        static class Child {
            int candy;
            final int index;
            final int rating;

            public Child(int index, int rating) {
                this.index = index;
                this.rating = rating;
            }
        }
    }

    /**
     * 时间复杂度　ｎ
     * 空间复杂度　１
     */
    class Solution2 implements Candy {

        @Override
        public int candy(int[] ratings) {
            if (ratings == null || ratings.length < 2) {
                return 1;
            }
            int res = 0;
            int last = ratings.length - 1;
            int lastMin = 1;
            for (int i = ratings.length - 2; i >= -1; i--) {
                if (i == -1 || ratings[i] >= ratings[i + 1]) {
                    int n = last - i;
                    res += (1 + n) * n / 2;
                    if (lastMin > n) {
                        res += lastMin - n;
                    }
                    last = i;
                    if (i != -1 && ratings[i] == ratings[i + 1]) {
                        lastMin = 1;
                    } else {
                        lastMin = n == 1 ? lastMin + 1 : 2;
                    }
                }
            }
            return res;
        }

    }
}

class CandyTest extends AbstractTest<Candy> {
}
