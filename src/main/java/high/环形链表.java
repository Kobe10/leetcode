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
 * @date Created in 2021年03月25日 18:23
 * @since 1.0
 */

public class 环形链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 环形链表
     * @param head
     * @return
     */
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 两个链表相交  但是相交的地方不一定是环的入口
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                // 相交了  相交之后

            }
        }

    }
}
