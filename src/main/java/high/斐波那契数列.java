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
 * @date Created in 2021年04月05日 16:31
 * @since 1.0
 */
public class 斐波那契数列 {
    public static int fib(int n) {
//        // 一种递归
        if (n == 0 || n == 1 ) {
            return n;
        }
//        return fib(n - 1) + fib(n - 2);

        // 一种双变量来控制前一个值
        int p = 0, q = 1;
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = p + q;
            p = q;
            q = x;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
