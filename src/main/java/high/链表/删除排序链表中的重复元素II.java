package high.链表;

import java.util.HashMap;
import java.util.Map;

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
 * @date Created in 2021年04月05日 15:29
 * @since 1.0
 */
public class 删除排序链表中的重复元素II {

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
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     * <p>
     * 返回同样按升序排列的结果链表。
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 设置一个伪头结点
        ListNode tail = new ListNode();
        tail.next = head;
        ListNode real = tail;
        Map<Integer, Integer> map = new HashMap<>();
        // 针对重复出现的元素做标记， 删除完其他所有重复元素之后，再把当前这个重复元素删掉
        while (tail.next != null) {
            if (tail.next.next != null) {
                if (tail.next.val == tail.next.next.val) {
                    map.put(tail.next.val, tail.next.val);
                    // 相等，
                    tail.next.next = tail.next.next.next;
                } else {
                    if (map.containsKey(tail.next.val)) {
                        // 判断靠左的节点是不是已经是删除过几次的元素了，如果是，那么将左边的节点移除，并且删除标记
                        tail.next = tail.next.next;
                    } else {
                        tail = tail.next;
                    }
                }
            } else {
                if (map.containsKey(tail.next.val)) {
                    // 判断靠左的节点是不是已经是删除过几次的元素了，如果是，那么将左边的节点移除，并且删除标记
                    tail.next = null;
                } else {
                    // 这里判断  最后的这个节点是不是重复节点
                    break;
                }
            }
        }
        return real.next;
    }
}
