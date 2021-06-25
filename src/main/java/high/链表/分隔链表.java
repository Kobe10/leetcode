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
 * @date Created in 2021年04月05日 22:09
 * @since 1.0
 */
public class 分隔链表 {
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

    /**
     * 分隔链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 这个和奇偶调换差不多  都是需要找到调换的节点
        ListNode small = new ListNode();
        ListNode smallHead = small;
        ListNode big = new ListNode();
        ListNode bigHead = big;
        while (head != null) {
            // 找到第一个大于等于 x的节点
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            if (head.val >= x) {
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            head = head.next;
        }
        // 这里可能会有后续的环链表出现  所以将大于的节点的next给置为空
        bigHead.next = null;
        smallHead.next = big.next;
        return small.next;
    }
}
