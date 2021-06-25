//package high.并发包;
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
// * @date Created in 2021年04月02日 14:24
// * @since 1.0
// */
//public class LeeLock  {
//
//    private static class Sync extends AbstractQueuedSynchronizer {
//        @Override
//        protected boolean tryAcquire (int arg) {
//            return compareAndSetState(0, 1);
//        }
//
//        @Override
//        protected boolean tryRelease (int arg) {
//            setState(0);
//            return true;
//        }
//
//        @Override
//        protected boolean isHeldExclusively () {
//            return getState() == 1;
//        }
//    }
//
//    private Sync sync = new Sync();
//
//    public void lock () {
//        sync.acquire(1);
//    }
//
//    public void unlock () {
//        sync.release(1);
//    }
//}
