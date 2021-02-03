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
 * @date Created in 2020年12月17日 17:44
 * @since 1.0
 */
public class dayin implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            while (count <= 100) {
                this.notify();
                System.out.println(Thread.currentThread().getName() + count++);


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        dayin dayin1 = new dayin();
        new Thread(dayin1, "A").start();
        new Thread(dayin1, "B").start();
    }
}
