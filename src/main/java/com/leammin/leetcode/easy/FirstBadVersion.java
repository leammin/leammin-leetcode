package com.leammin.leetcode.easy;

/**
 * 278. 第一个错误的版本
 *
 * <div><p>你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。</p>
 *
 * <p>假设你有 <code>n</code> 个版本 <code>[1, 2, ..., n]</code>，你想找出导致之后所有版本出错的第一个错误的版本。</p>
 *
 * <p>你可以通过调用&nbsp;<code>bool isBadVersion(version)</code>&nbsp;接口来判断版本号 <code>version</code> 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * <code>调用 isBadVersion(3) -&gt; false
 * 调用 isBadVersion(5)&nbsp;-&gt; true
 * 调用 isBadVersion(4)&nbsp;-&gt; true
 *
 * 所以，4 是第一个错误的版本。&nbsp;</code></pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-06
 */
public class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public static int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int mid;

        while (low < high - 1) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private static boolean isBadVersion(int version) {
        if (version <= 4) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
