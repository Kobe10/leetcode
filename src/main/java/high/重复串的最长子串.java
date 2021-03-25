package high;

import java.util.HashSet;
import java.util.Set;

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
 * @date Created in 2021年03月24日 22:13
 * @since 1.0
 */
public class 重复串的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        // 字符串转换为数组
        // 只要记住 开始结束的下标即可
        Set<Character> set = new HashSet<Character>();
        char[] nums = s.toCharArray();
        if (nums.length == 0) {
            return 0;
        }
        // (abc)abcbb
        int maxLength = 0;
        int min = 0;
        int max = 0;
        int start = 0;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            // 右指针从左往右移动
            if (i > 0) {
                // 左指针向左移动一格，删掉一个字符
                set.remove(s.charAt(i - 1));
            }
            // 里面再来一个循环  这个循环是判断left起点最远能到右边多长的位置
            while (right + 1 < nums.length && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            // 清空set 记录长度  记录最长字符串下标位置
            min = i;
            max = right;
            // 当最大值  大于等于的时候   长度并不累加， 默认选择第一个子串为准
            if (maxLength >= (max - min + 1)) {
                start = start;
            } else {
                start = min;
            }
            maxLength = Math.max(maxLength, max - min + 1);
        }
        System.out.println(s.substring(start, maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
