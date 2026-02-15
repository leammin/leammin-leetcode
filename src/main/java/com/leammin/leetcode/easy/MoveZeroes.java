package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 283. 移动零
 *
 * <div><p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[0,1,0,3,12]</code>
 * <strong>输出:</strong> <code>[1,3,12,0,0]</code></pre>
 *
 * <p><strong>说明</strong>:</p>
 *
 * <ol>
 * <li>必须在原数组上操作，不能拷贝额外的数组。</li>
 * <li>尽量减少操作次数。</li>
 * </ol>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-29
 */
public interface MoveZeroes {
    void moveZeroes(int[] nums);

    static Testsuite<MoveZeroes> testsuite() {
        return Testsuite.<MoveZeroes>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {0, 1, 0, 3, 12};
                    t.moveZeroes(nums);
                    return nums;
                }, new int[]{1, 3, 12, 0, 0}))
                .build();
    }


    class Solution implements MoveZeroes {
        @Override
        public void moveZeroes(int[] nums) {
            int lastZero = 0;
            for (int zeroIndex = 0; zeroIndex < nums.length - 1 && lastZero < nums.length - 1; zeroIndex++) {
                if (nums[zeroIndex] == 0) {
                    for (int noZeroIndex = Math.max(lastZero, zeroIndex) + 1; noZeroIndex < nums.length; noZeroIndex++) {
                        if (nums[noZeroIndex] != 0) {
                            nums[zeroIndex] = nums[noZeroIndex];
                            nums[noZeroIndex] = 0;
                            lastZero = zeroIndex;
                            break;
                        }
                    }
                }
            }
        }
    }

    class Solution1 implements MoveZeroes {
        @Override
        public void moveZeroes(int[] nums) {
            for (int zeroIndex = 0; zeroIndex < nums.length - 1; zeroIndex++) {
                if (nums[zeroIndex] == 0) {
                    for (int noZeroIndex = zeroIndex + 1; noZeroIndex < nums.length; noZeroIndex++) {
                        if (nums[noZeroIndex] != 0) {
                            int[] noZeroAfterIndexArray = new int[noZeroIndex - zeroIndex + 1];
                            noZeroAfterIndexArray[0] = noZeroIndex;
                            int noZeroAfterIndexArraySize = 1;
                            for (int noZeroAfterIndex = noZeroIndex + 1; noZeroAfterIndex < nums.length && noZeroAfterIndexArraySize < noZeroAfterIndexArray.length; noZeroAfterIndex++) {
                                if (nums[noZeroAfterIndex] != 0) {
                                    noZeroAfterIndexArray[noZeroAfterIndexArraySize] = noZeroAfterIndex;
                                    noZeroAfterIndexArraySize++;
                                }
                            }
                            for (int i = 0; i < noZeroAfterIndexArraySize; i++) {
                                nums[zeroIndex] = nums[noZeroAfterIndexArray[i]];
                                nums[noZeroAfterIndexArray[i]] = 0;
                                zeroIndex++;
                            }
                            zeroIndex--;
                            if (noZeroAfterIndexArraySize < noZeroAfterIndexArray.length) {
                                return;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    class Solution3 implements MoveZeroes {

        @Override
        public void moveZeroes(int[] nums) {
            int zero = 0;
            for (int fast = 0, slow = 0; fast < nums.length; fast++) {
                if (nums[fast] == 0) {
                    zero++;
                } else {
                    nums[slow++] = nums[fast];
                }
            }
            for (int i = nums.length - zero; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}

class MoveZeroesTest extends AbstractTest<MoveZeroes> {
}
