package interview;

import com.google.common.collect.Lists;

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
 * @date Created in 2021年01月21日 18:46
 * @since 1.0
 */
public class 增减数组排序 {
    public static void main(String[] args) {
        List<Integer> tempList = Lists.newArrayList(1, 2, 3, 4, 10, 9, 8, 7, 6, 4);
        List<Integer> result = Lists.newArrayList();
        int left = 0, right = tempList.size() - 1;
        while (left <= right) {
            if (tempList.get(left) <= tempList.get(right)) {
                result.add(tempList.get(left));
                left++;
            } else {
                result.add(tempList.get(right));
                right--;
            }
        }
        result.forEach(System.out::println);
    }
}
