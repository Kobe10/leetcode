package com.fuzq.leetcode.字节跳动;

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
 * @date Created in 2020年08月03日 21:03
 * @since 1.0
 */

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
public class P5LongestPalindromicSubstring {

    // 解答思路: 这是一个典型的动态规划的算法，就是从小到大一步一步去求最优解的过程
    // 动态规划：所有的动态规划都是一个填二维表格的过程，这里的回文子串只是需要填写上半部分的表格(因为遍历的时候 i是小于等于j的， 不可能j小于i)
    // 1、状态： dp[i][j] 表示子串 s[i][j]是否是回文子串
    // 2、状态转移方程： dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1] (头尾字符相等，并且它的子串也是回文，那么这个字符串就是回文)
    // 3、边界条件：j-1 - (i+1) > 1  ====>  j-i<3 的时候  套用上面的方程，那么就不用判断了，dp[i][j]一定回文
    // 4、初始化：二维表格中对角线中的值一定是回文串， 初始化为true   dp[i][i] = true
    // 5、输出 得到一个状态值为true的时候， 就记录下他的起始位置和最大回文子串的长度  ， 最后利用这两个属性输出结果
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            // 特判
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;

            // 1. 状态定义
            // dp[i][j] 表示s[i...j] 是否是回文串


            // 2. 初始化
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] chars = s.toCharArray();
            // 3. 状态转移
            // 注意：先填左下角
            // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    // 头尾字符不相等，不是回文串
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        // 相等的情况下
                        // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            // 状态转移
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                    // 此时更新记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            // 4. 返回值
            return s.substring(begin, begin + maxLen);
        }
    }
}
