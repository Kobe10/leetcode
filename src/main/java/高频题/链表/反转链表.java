package 高频题.链表;

/**
 * <p></p>
 * <p> 反转链表
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年06月25日 11:18 上午
 * @since 1.0
 */
public class 反转链表 {
    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head
     * @return 高频题.链表.反转链表.ListNode
     * @Author fuzhiqiang
     * @Description // 核心思路： 建立伪节点  每次只反转一个指针
     * @Date 2021/6/25
     */
    public ListNode reverseList(ListNode head) {
        ListNode preHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = preHead;
            preHead = cur;
            cur = temp;
        }
        return preHead;
    }
}
