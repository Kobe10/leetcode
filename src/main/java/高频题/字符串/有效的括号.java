package 高频题.字符串;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p></p>
 * <p> 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月19日 4:31 下午
 * @since 1.0
 */

public class 有效的括号 {
    // 栈实现
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        // 闭括号做key  方便判断是否存在
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // 第一个不能为闭括号  栈顶元素必须和闭括号对应
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                // 出栈
                stack.pop();
            } else {
                // 入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
