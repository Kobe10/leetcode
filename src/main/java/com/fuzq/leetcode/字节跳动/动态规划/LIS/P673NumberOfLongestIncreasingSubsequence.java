package com.fuzq.leetcode.字节跳动.动态规划.LIS;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2020年09月14日 13:00
 * @since 1.0
 */

//给定一个未排序的整数数组，找到最长递增子序列的个数。
//
// 示例 1:
//
//
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//
//
// 示例 2:
//
//
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
// Related Topics 动态规划

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解题思路: 1、 https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-leetcode/  (看代码比较好理解，  题目解释的不够清晰)
 * 2、 https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/yi-bu-yi-bu-tui-dao-chu-zui-you-jie-fa-2-zui-chang/
 */
public class P673NumberOfLongestIncreasingSubsequence {
    static class Solution {
        public static int findNumberOfLIS(int[] nums) {
            int N = nums.length;
            if (N <= 1) return N;
            int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
            int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
            Arrays.fill(counts, 1);

            for (int j = 0; j < N; ++j) {
                for (int i = 0; i < j; ++i)
                    if (nums[i] < nums[j]) {
                        if (lengths[i] >= lengths[j]) {
                            lengths[j] = lengths[i] + 1;
                            counts[j] = counts[i];
                            // 如果 lengths[i] + 1 == lengths[j]   表示当前位置j不是第一次找到最长长度的组合序列  所以j这个位置  会有多种组合序列   所以他的结果就是  count[i] + counts[j] （count[j]  会有多次叠加的结果值）
                        } else if (lengths[i] + 1 == lengths[j]) {
                            counts[j] += counts[i];
                        }
                    }
            }

            int longest = 0, ans = 0;
            for (int length : lengths) {
                longest = Math.max(longest, length);
            }
            for (int i = 0; i < N; ++i) {
                if (lengths[i] == longest) {
                    ans += counts[i];
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 5, 4, 3, 7};
            System.out.println(findNumberOfLIS(nums));
        }
    }
}
