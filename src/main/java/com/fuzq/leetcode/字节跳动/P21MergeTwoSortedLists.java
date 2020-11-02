package com.fuzq.leetcode.字节跳动;

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
 * @date Created in 2020年08月09日 14:22
 * @since 1.0
 */
//java:合并两个有序链表

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1194 👎 0

//解题思路一： 双指针方式： 时间复杂度O(n)
// 1、递归方式处理，两个链表的长度，把短的放前面处理； 这种方式是将两个链表弄到一个新的链表中去
//遍历较长长度，然后依次对比两个链表上的值，将值赋值给一个新的长度的链表
//当其中有一个链表先遍历完的话，直接将剩余链表挂到新的链表的末尾即可

//解题思路二：直接在原链表上操作，递归操作
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
    }

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

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //解题思路一：初始化链表头部，单独遍历(可以使用双指针)
            ListNode dum = new ListNode(0), cur = dum;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dum.next;

            //递归解法
//            if (l1 == null) {
//                return l2;
//            } else if (l2 == null) {
//                return l1;
//            } else if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
        }
    }
}
