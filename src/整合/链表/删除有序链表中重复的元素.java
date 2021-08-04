package 整合.链表;

import base.ListNode;

public class 删除有序链表中重复的元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.val == cur.val) {
                    temp = temp.next;
                }
                pre.next = temp;
                cur = temp;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
