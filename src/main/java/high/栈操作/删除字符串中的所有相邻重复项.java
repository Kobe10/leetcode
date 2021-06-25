package high.栈操作;

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
 * @date Created in 2021年04月05日 21:58
 * @since 1.0
 */
public class 删除字符串中的所有相邻重复项 {

    public static String removeDuplicates(String S) {
        // 栈操作  操作删除元素
        Stack<Character> stack = new Stack<>();
        int length = S.length();
        int i = 0;
        while (i < length) {
            if (!stack.isEmpty()) {
                Character temp = stack.peek();
                if (temp == S.charAt(i)) {
                    stack.pop();
                    i++;
                    continue;
                }
            }

            stack.add(S.charAt(i));
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String s  = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
