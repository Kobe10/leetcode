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
 * @date Created in 2021年04月05日 21:51
 * @since 1.0
 */
public class 删除排序数组中的重复项 {
    // 因为是排序数组   所以我们可以用双指针搞定
    // 有点类似于排序链表的删除重复项
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int left = 0;
        for (int right = 1; right < length; right++) {
            // 如果遍历到前后不相等了  说明已经把中间重复的元素给过滤掉了
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        // 直接返回去除重复元素之后的数组长度
        return left + 1;
    }
}
