package high.链表;

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
 * @date Created in 2021年03月30日 09:58
 * @since 1.0
 */

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个结点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这里有个坑   就是需要判断特殊情况  删除头节点，这里直接返回head.next
        // 其余情况就直接找到倒数K个节点的父节点即可  然后返回
        // 删除第N个节点
        if (head == null) {
            return null;
        }
        ListNode temp1 = head, temp2 = head;
        while (temp1 != null && n > 0) {
            temp1 = temp1.next;
            n--;
        }
        if (temp1 == null) {
            // 删除头节点
            return head.next;
        } else {
            while (temp1 != null) {
                temp1 = temp1.next;
                if (temp1 != null) {
                    temp2 = temp2.next;
                }
            }
            // 删除节点
            if (temp2.next != null) {
                temp2.next = temp2.next.next;
            }
        }
        return head;
    }
}
