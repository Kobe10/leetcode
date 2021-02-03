package interview;

import java.util.List;

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
 * @date Created in 2020年12月29日 15:27
 * @since 1.0
 */
public class 链表反转 {
    public class ListNode {
        public int val;
        public ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 链表逆序
    public ListNode resverList(ListNode node) {
        ListNode pre = node;
        ListNode cur = null;
        while (pre != null) {
            // 记住下一个节点
            ListNode t = pre.next;
            // 然后将指针转过来 指向后方
            pre.next = cur;
            // 然后两个指针依次增加一位
            cur = pre;
            pre = t;
        }
        return pre;
    }

    // 链表合并
    public ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(0);
        while (node1 != null && node2 != null) {

        }
        return pre;
    }
}
