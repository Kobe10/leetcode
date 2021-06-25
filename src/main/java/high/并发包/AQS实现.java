//package high.并发包;
//
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//
///**
// * <p></p>
// * <p>
// * <PRE>
// * <BR>    修改记录
// * <BR>-----------------------------------------------
// * <BR>    修改日期         修改人          修改内容
// * </PRE>
// *
// * @author fuzq
// * @version 1.0
// * @Desc
// * @date Created in 2021年04月02日 14:23
// * @since 1.0
// */
//public class AQS实现 {
//
//    static int count = 0;
//    static LeeLock leeLock = new LeeLock();
//
//    public static void main (String[] args) throws InterruptedException {
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run () {
//                try {
//                    leeLock.lock();
//                    for (int i = 0; i < 10000; i++) {
//                        count++;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    leeLock.unlock();
//                }
//
//            }
//        };
//        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println(count);
//    }
//
//}
