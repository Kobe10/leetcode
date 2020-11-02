package com.fuzq.leetcode.字节跳动;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 8794 👎 0

// 解题思路
// 1、暴力破解法  遍历两遍， 找到结果直接返回
// 2、遍历两遍map，将数组存入map中，遍历一遍数组，将符合条件的存入map 中  ： key: 符合条件的数字，value：数据下标
// 3、遍历一遍map，边遍历的时候边往map里面塞值，然后顺便判断是否包含

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

//java:两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }

}