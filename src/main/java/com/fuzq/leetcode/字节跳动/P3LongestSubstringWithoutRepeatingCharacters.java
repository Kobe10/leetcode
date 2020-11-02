package com.fuzq.leetcode.字节跳动;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4083 👎 0

//java:无重复字符的最长子串


import java.util.*;

// 解题思路：
// 1、滑动窗口解题 --  初始化变量   头、尾指针、map存储扫描过的字符的下一个字符的下标的下标
// 遍历数组，通过尾部指针向后移动，直到碰到map中的重复元素出现，将头部指针指向(靠近头部指针的重复元素的下一个下标，然后继续移动尾部指针)；每次都需要更新子串最大的长度
public class P3LongestSubstringWithoutRepeatingCharacters {


    static class Solution {
        public static void main(String[] args) {

            Solution solution = new Solution();
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            lengthOfLongestSubstring(s);
        }
        public static int lengthOfLongestSubstring(String s) {
            char[] s1 = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            Integer result = 0;
            Integer head = 0;
            Integer tail = 0;

            while (tail < s1.length) {
                if (map.containsKey(s1[tail])) {
                    //靠近head出现的重复元素的位置
                    head = Math.max(map.get(s1[tail]) + 1, head);
                }
                map.put(s1[tail], tail);
                result = Math.max(result, tail - head + 1);
                tail++;
            }
            System.out.println(result);
            return result;
        }
    }
}
