package 高频题.链表;

/**
 * <p></p>
 * <p> 反转链表升级版
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年06月25日 11:40 上午
 * @since 1.0
 */
public class 反转链表升级版 {
    /**
     * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */
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

    // 思路:  核心也是反转链表   这里限制了长度， 需要找到right的后一个节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }
}
