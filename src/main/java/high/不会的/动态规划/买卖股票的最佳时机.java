package high.不会的.动态规划;

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
 * @date Created in 2021年04月02日 21:53
 * @since 1.0
 */
public class 买卖股票的最佳时机 {
    public static int maxProfit(int[] prices) {
        // 核心的  最低点买入  最高点卖出
        // 只需要一次遍历找到数组最小值，同时找到最小值的时候去计算最大利润，因为卖出是在后一天卖出的
        int minPrice = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                // 这里当前值大于了最小值，可以计算利润了
                int num = prices[i] - minPrice;
                max = Math.max(num, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }
}
