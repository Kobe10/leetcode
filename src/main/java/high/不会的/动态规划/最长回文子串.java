package high.不会的.动态规划;

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
 * @date Created in 2021年03月26日 15:00
 * @since 1.0
 */

/**
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class 最长回文子串 {
    public static String longestPalindrome(String s) {
        int max_length = -1;
        String ans = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        // 动态规划   这里划分情况
        // 当长度为1时   一定是回文串  dp[i][i]=true
        // 当长度为2时   s[i]=s[j] j=i+1 一定是回文串  dp[i][i+1]=true
        // 当长度大于2之后  就是dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
        for (int length = 0; length < s.length(); length++) {
            for (int left = 0; left + length < s.length(); left++) {
                int right = left + length;
                if (length == 0) {
                    dp[left][right] = true;
                } else if (length == 1) {
                    if (s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = false;
                    }
                } else {
                    if (dp[left + 1][right - 1] && s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = false;
                    }
                }
                // 设置完一遍之后  需要获取最大值
                if (right - left + 1 > max_length && dp[left][right]) {
                    ans = s.substring(left, right + 1);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
