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
 * @date Created in 2021年04月04日 20:46
 * @since 1.0
 */
public class Excel表列序号 {
    public int titleToNumber(String columnTitle) {
        // 26进制  方法一
        // 1、 维护一个map  26进制的所有的序号
        // 2、 遍历字符串数组 从后往前，然后依次累加


        // 方法二
        // 直接顺序遍历    ans = ans * 26 + num;   这个和十进制的转换不一样(这里因为是用字母代替，  所以可以知道每一位自身所在的位数锁代表的值)
        // ZY   Z表示 自己的位置是总共有26位，每一位都是26  所以当前位置的十进制的值是26*26
        int ans = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
