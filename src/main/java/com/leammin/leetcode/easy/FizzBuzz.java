package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * <div><p>写一个程序，输出从 1 到 <em>n</em> 数字的字符串表示。</p>
 *
 * <p>1. 如果&nbsp;<em>n&nbsp;</em>是3的倍数，输出“Fizz”；</p>
 *
 * <p>2. 如果&nbsp;<em>n&nbsp;</em>是5的倍数，输出“Buzz”；</p>
 *
 * <p>3.如果&nbsp;<em>n&nbsp;</em>同时是3和5的倍数，输出 “FizzBuzz”。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-01
 */
public interface FizzBuzz {
    List<String> fizzBuzz(int n);

    class Solution implements FizzBuzz {
        @Override
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    res.add("FizzBuzz");
                } else if (i % 5 == 0) {
                    res.add("Buzz");
                } else if (i % 3 == 0) {
                    res.add("Fizz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }

}
