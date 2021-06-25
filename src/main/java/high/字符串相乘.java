package high;

import java.util.ArrayList;
import java.util.List;

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
 * @date Created in 2021年04月05日 17:38
 * @since 1.0
 */
public class 字符串相乘 {
    /**
     * 分清楚关系  被乘数的位数决定了 相加数的个数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int lengthA = num1.length();
        int lengthB = num2.length();
        int levelA = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = lengthA - 1; i >= 0; i--) {
            int flag = 0;
            int result = 0;
            int numA = num1.charAt(i) - '0';
            int levelB = 0;
            int levelAA = levelA;
            for (int j = lengthB - 1; j >= 0; j--) {
                int numB = num2.charAt(j) - '0';
                int levelBB = levelB;
                int num = numA * numB ;
                flag = num / 10;
                while (levelBB > 0) {
                    num *= 10;
                    levelBB--;
                }
                levelB++;
                result = result + num;
            }
            while (levelAA > 0) {
                result *= 10;
                levelAA--;
            }
            levelA++;
            list.add(result);
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        String s1 = "123", s2 = "456";
        System.out.println(multiply(s1, s2));
    }
}
