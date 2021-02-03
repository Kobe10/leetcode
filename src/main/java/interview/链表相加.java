//package interview;
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
// * @date Created in 2020年12月24日 12:37
// * @since 1.0
// */
//public class 链表相加 {
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//    //9->8->2    1->2      0->1->3
//    public static ListNode addTwoLink(ListNode h1, ListNode h2) {
//        ListNode result = h1;
//        ListNode cur;
//        // 记录满10 标志
//        int out10Flag = 0;
//        while (h1 != null && h2 != null) {
//            //每位相加 记录是否满10
//            int num = h1.val + h2.val;
//            if (out10Flag > 0) {
//                num += 1;
//            }
//            if (num >= 10) {
//                num -=10;
//                out10Flag = 1;
//            }
//            // 直接修改h1
//            h1.val = num;
//            if (h1.next == null) {
//                cur = h1;
//            }
//            h1 = h1.next;
//            h2 = h2.next;
//        }
//        // 抽取
//        if (h1 == null) {
//            // 记录h2 节点
//            ListNode cur = h2;
//            //遍历 h2
//            while (h2 != null) {
//                int num = out10Flag + h2.val;
//                if (num >= 10) {
//                    num -=10;
//                    out10Flag = 1;
//                }
//                h2.val = num;
//                h2 = h2.next;
//            }
//            h1.next = cur;
//        }
//        //
//        if (h2 == null) {
//            //遍历 h2
//            while (h1 != null) {
//                int num = out10Flag + h1.val;
//                if (num >= 10) {
//                    num -=10;
//                    out10Flag = 1;
//                }
//                h1.val = num;
//                if (h1 == nu)
//                h1 = h1.next;
//            }
//        }
//        //
//        if (out10Flag == 1) {
//            ListNode l = new ListNode(out10Flag);
//            h1.next = l;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        ListNode h1 = new ListNode(9);
//        ListNode h11 = new ListNode(8);
//        ListNode h111 = new ListNode(2);
//        ListNode h2 = new ListNode(1);
//        ListNode h22 = new ListNode(2);
//        h1.next = h11;
//        h11.next = h111;
//
//        h2.next = h22;
//        System.out.println(addTwoLink(h1, h2));
//    }
//}
