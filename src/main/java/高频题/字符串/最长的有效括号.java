package 高频题.字符串;

/**
 * <p></p>
 * <p> 最长的有效括号 : https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月19日 4:39 下午
 * @since 1.0
 */
public class 最长的有效括号 {
    // 正向逆向思维解法
    public static int longestValidParentheses(String s) {
        // 正向遍历  遇见( left+1  遇见) right+1  最大值max实时计算
        int left = 0, right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                right++;
            }
            // 当相等是  表示符合条件
            if (left == right) {
                result = Math.max(result, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = 0;
        right = 0;
        // 逆向遍历 遇见) right+1  遇见( left+1  最大值max实时计算
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                left++;
            }
            if (s.charAt(i) == '(') {
                right++;
            }
            // 当相等是  表示符合条件
            if (left == right) {
                result = Math.max(result, (right) * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}
