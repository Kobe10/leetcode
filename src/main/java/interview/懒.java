package interview;

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
 * @date Created in 2020年12月17日 14:16
 * @since 1.0
 */
public class 懒 {
    // 懒汉
    private static 懒 object = null;
    public synchronized Object get() {
        if (object == null) {
            object = new 懒();
        }
        return object;
    }

    private static Object object1 = new Object();
    public static Object get1() {
        return object1;
    }
}
