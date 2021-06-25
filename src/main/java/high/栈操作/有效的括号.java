package high.栈操作;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

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
 * @date Created in 2021年03月25日 18:57
 * @since 1.0
 */
public class 有效的括号 {
    // 这个题用栈来实现  同时需要用map记录一下对应的 括号对
    public static boolean isValid(String s) {
        Stack<Character> strings = new Stack<>();
        int length = s.length();
        Map<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                strings.add(s.charAt(i));
            }
            if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (!strings.isEmpty()) {
                    Character temp = strings.pop();
                    if (temp != map.get(s.charAt(i))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (!strings.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("()"));
        System.out.println(isValid("}"));
    }
}
