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
 * 先说两个注意的点：
 * (1)调用了notify()或者notigyAll()并不是立马就释放锁的，需要等待当前线程把临界区的代码执行完才释放。
 * (2)调用wait()之后当前线程会立即阻塞，JVM会在等待wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
 *
 *
 * 为什么实现Runnable接口，而不是继承Thread类？
 * 答：因为这道题让我们两个线程顺序打印0~100。Thread不适合资源共享，而Runnable很适合资源共享。提一下为什么Runnable适合资源共享，因为实现Runnable和Callable接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过Thread来调用。可以理解为任务是通过线程驱动从而执行的。
 *
 *
 * Runnable相比与Thread具有的优势
 *
 * 适合多个相同的程序代码的线程去处理同一个资源
 * 可以避免java中的单继承的限制
 * 增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * 线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
 *
 *
 *
 * 等待通知机制的定义
 * 先来看一下等待 / 通知的定义（摘抄自《Java并发编程的艺术》）：等待 / 通知的相关方法是任何一个Java对象都具有的。等待 / 通知机制，是指一个线程A调用了对象O的wait()方法进入等待状态，而另外一个线程B调用了对象O的notify()或者notifyAll()方法，线程A收到通知后从对象O的wait()方法返回，进而执行后续操作。
 *
 *
 * 代码一处的this.notify()调用后，会等待synchronized(this){}的所有代码执行完毕之后才释放，并不是立马释放的
 *
 *
 * 代码二处的this.wait()
 * 当前线程调用了this.wait()方法之后，阻塞的是当前线程，然后唤醒等待this锁的线程
 *
 *
 *
 *
 * 作者：学就完事了
 * 链接：https://juejin.cn/post/6844904067269935112
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date Created in 2020年12月17日 16:43
 * @since 1.0
 */
public class 多线程打印 implements Runnable{
    private  int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            while (count <= 100) {
                //唤醒其他需要this锁的进程来竞争锁，当前进程等到临界区代码执行完毕才释放锁
                this.notify();//代码一处
                System.out.println(Thread.currentThread().getName() + "当前数字是：" + count++);

                //休息一段时间，放大差异
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //立即阻塞当前线程
                try {
                    this.wait();//代码二处
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        多线程打印 printThread = new 多线程打印(); //代码三处
        new Thread(printThread, "Thread-A").start();
        new Thread(printThread, "Thread-B").start();

    }
}
