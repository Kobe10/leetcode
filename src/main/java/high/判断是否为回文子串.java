package high;

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
 * @date Created in 2021年04月02日 20:37
 * @since 1.0
 */
public class 判断是否为回文子串 {
    public boolean isPalindrome(String s) {
        // 双指针   头尾遍历并且两个指针的位置的字符串相等
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // 忽略大小写 并且只保留字母和数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 去掉不符合的字符，然后再来进行比较
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
