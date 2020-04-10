package com.leammin.leetcode.undone.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 
 * <p>编写一个算法来判断一个数是不是&ldquo;快乐数&rdquo;。</p>
 * 
 * <p>一个&ldquo;快乐数&rdquo;定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。</p>
 * 
 * <p><strong>示例:&nbsp;</strong></p>
 * 
 * <pre><strong>输入:</strong> 19
 * <strong>输出:</strong> true
 * <strong>解释: 
 * </strong>1<sup>2</sup> + 9<sup>2</sup> = 82
 * 8<sup>2</sup> + 2<sup>2</sup> = 68
 * 6<sup>2</sup> + 8<sup>2</sup> = 100
 * 1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface HappyNumber {
    boolean isHappy(int n);

    class Solution implements HappyNumber {

        @Override
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (!set.contains(n)) {
                if (n == 1) {
                    return true;
                }
                set.add(n);
                int newN = 0;
                while (n > 0) {
                    int x = n % 10;
                    newN += x * x;
                    n /= 10;
                }
                n = newN;
            }
            return false;
        }
    }

    class Best implements HappyNumber {

        @Override
        public boolean isHappy(int n) {
            if (n == 1) {
                return true;
            }
            int slow = n;
            int fast = next(n);
            while (slow != fast) {
                if (slow == 1 || fast == 1) {
                    return true;
                }
                slow = next(slow);
                fast = next(next(fast));
            }
            return false;
        }

        private int next(int n) {
            int next = 0;
            while (n > 0) {
                int x = n % 10;
                next += x * x;
                n /= 10;
            }
            return next;
        }
    }
}
