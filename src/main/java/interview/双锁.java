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
public class 双锁 {

    // 恶汉
    private volatile static 双锁 object1 = null;

    public static Object get1() {
        if (object1 == null) {
            synchronized (双锁.class) {
                if (object1 == null) {
                    object1 = new 双锁();
                }
            }
        }
        return object1;
    }
    // 线程安全  2次加锁

    // 当单例对象已经被创建之后，因为是内存可见的--volatile修饰，多个线程可以同时执行第一个if条件判断并且拿到单例对象。
    // 如果未创建，那就锁住当前资源，进行创建
    // volatile可能更多的作用是用作禁止指令重排序，防止线程拿到未完全初始化的单例对象对象
    // 这里利用了volatile的可见性和有序性，  和synchronize的原子性
}
