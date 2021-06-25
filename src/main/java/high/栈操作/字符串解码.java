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
 * @date Created in 2021年04月05日 20:11
 * @since 1.0
 */
public class 字符串解码 {
    public static String decodeString(String s) {
        // 开始循环遍历进栈  碰到 "[" 进栈   碰到数字也进栈
        // 每次都把一个完整的字符串入栈，  碰到[ 就会将之前拼接好的字符串入栈了，  当碰到]就开始出栈，直到碰到数字，然后用数字进行翻倍
        // 判断 如果为字母直接拼接，如果是先出现数字了，先进栈，然后把括号的字母也是进栈，碰到
        // 三个条件判断
        Stack<Integer> int_res = new Stack<>();
        Stack<String> str_res = new Stack<>();
        int beishu = 0; // 开始的是高位  所以利用高位每次乘以10
        int length = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // 判断是否为数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 如果是数字  也是直接入栈  进入数字栈   但是这里有一个坑 就是这个数字不是各位数，需要累加
                beishu = beishu * 10 + Integer.parseInt(s.charAt(i) + "");
            } else if (s.charAt(i) == '[') {
                // 这里就可以将倍数入栈，并且进行初始化
                int_res.add(beishu);
                beishu = 0;
                // 开始进栈了  将之前的所有字符累加的进栈
                str_res.add(res.toString());
                // 将res 置为空  这时候再累加的就是[]中的数字了
                res = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                // 获取数字栈的值
                int num = int_res.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    // 循环多次  累加字符
                    temp.append(res);
                }
                // 累加完继续放入栈中
                res = new StringBuilder(str_res.pop() + temp);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "11[a2[c]]";
        System.out.println(decodeString(s));
    }
}
