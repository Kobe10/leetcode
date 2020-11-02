package com.fuzq.leetcode.字节跳动.动态规划.最大子数组和系列;

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
 * @date Created in 2020年08月09日 14:42
 * @since 1.0
 */
//java:最大子序和
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划

//解题思路一：动态规划：获取的公式是：   f(i)=max{f(i−1)+ai}
//这里有两种思路：一种是贪心，一种是动态规划
//动态规划：如果前一个元素大于0，就把当前值+前一个结果值  存储到一个数组中，  然后遍历完整个数组，取到数组中的最大值即可
//贪心算法：用两个全局变量存储：pre-->上一个值，maxResult 最大和；  每次比较 pre+cur与cur的大小， 取大的那个和 maxResult进行比较， 取其中大的作为maxResult

public class P53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //定义dp数组，dp数组中的每个值dp[i]代表着以nums[i]为结尾的最大子序和
        int[] dp = new int[n];
        //以nums[0]结尾的最大子序和就是nums[0]
        dp[0] = nums[0];
        //遍历，通过状态转移方程求得dp[i]的最大子序和
        for (int i = 1; i < n; ++i) {
            //dp[i]的最大子序和要么是自成一派最大，要么就是当前值加上前面i - 1个数的最大子序和
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        //遍历dp数组，求得dp数组中的最大值，就是该题的答案
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < dp.length; ++j) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
