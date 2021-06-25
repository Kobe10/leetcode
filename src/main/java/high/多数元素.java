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
 * @date Created in 2021年03月29日 18:54
 * @since 1.0
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class 多数元素 {

    public int majorityElement(int[] nums) {
        // 设置一个值 依次累加  如果当前值不等于就减一  和可重入锁加锁类似，最终剩下的那个数一定是最后的多数元素
        // 当flag为0的时候  需要重新给这个众数赋值，不然flag就会为负数了(就是加锁逻辑很类似)
        int num = nums[0];
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (flag ==0) {
                num = nums[i];
            }
            if (nums[i] == num) {
                flag++;
            } else {
                flag--;
            }
        }
        if (flag > 0) {
            return num;
        }
        return -1;
    }
}
